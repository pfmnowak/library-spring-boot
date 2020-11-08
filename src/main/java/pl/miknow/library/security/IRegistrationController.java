package pl.miknow.library.security;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import pl.miknow.library.security.RegistrationForm;
import pl.miknow.library.web.error.UserAlreadyExistException;

import javax.validation.Valid;

public interface IRegistrationController {
    String processRegistration(RegistrationForm form, Errors errors) throws UserAlreadyExistException;
}
