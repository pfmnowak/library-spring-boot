package pl.miknow.library.security;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.miknow.library.model.User;
import pl.miknow.library.service.UserService;
import pl.miknow.library.validation.Unique;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class RegistrationForm {
    // This is our User DTO Object (Data Transfer Object)
    @NotBlank(message = "Field cannot be empty.")
//    @Unique(service = UserService.class, fieldName = "email", message = "{email.unique.violation}")
    @Unique(service = UserService.class, fieldName = "email", message = "There is already an account with that email address.")
    private String email;
    @NotBlank(message = "Field cannot be empty.")
    @Size(min=5, message = "Min size is 5.")
    private String name;
    @NotBlank(message = "Field cannot be empty.")
    private String lastName;
    @NotBlank(message = "Field cannot be empty.")
    private String address;
    @NotBlank(message = "Field cannot be empty.")
    private String password;
    @NotBlank(message = "Field cannot be empty.")
    private String phoneNumber;

    public RegistrationForm() {
    }

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(email, name, lastName, address, passwordEncoder.encode(password), phoneNumber);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
