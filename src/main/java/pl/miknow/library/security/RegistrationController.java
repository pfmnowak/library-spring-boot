package pl.miknow.library.security;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.miknow.library.dao.UserRepository;
import pl.miknow.library.web.error.UserAlreadyExistException;

@Controller
@RequestMapping("/register")
public class RegistrationController implements IRegistrationController {

    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;

    public RegistrationController(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerForm() {
        if (isAuthenticated()) {
            return "redirect:search";
        }
        return "registration";
    }

    @PostMapping
    @Override
    public String processRegistration(RegistrationForm form) {
        if (emailExist(form.getEmail())) {
            throw new UserAlreadyExistException(
                    "There is already an account with that email address.");
        }
        userRepo.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }

    private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || AnonymousAuthenticationToken.class.isAssignableFrom(authentication.getClass())) {
            return false;
        }
        return authentication.isAuthenticated();
    }

    private boolean emailExist(String email) {
        return userRepo.findByUsername(email) != null;
    }
}
