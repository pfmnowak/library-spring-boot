package pl.miknow.library.security;

import pl.miknow.library.security.RegistrationForm;
import pl.miknow.library.web.error.UserAlreadyExistException;

public interface IRegistrationController {
    String processRegistration(RegistrationForm form) throws UserAlreadyExistException;
}
