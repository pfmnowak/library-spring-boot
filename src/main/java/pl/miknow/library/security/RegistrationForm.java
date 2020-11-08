package pl.miknow.library.security;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.miknow.library.model.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RegistrationForm {
    // This is our User DTO Object (Data Transfer Object)
    @NotNull
    @NotEmpty
    private String email;
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min=5, message = "Ty chuju!")
    private String name;
    @NotNull
    @NotEmpty
    private String lastName;
    @NotNull
    @NotEmpty
    private String address;
    @NotNull
    @NotEmpty
    private String password;
    @NotNull
    @NotEmpty
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
