package pl.miknow.library.security;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.miknow.library.model.User;

@Data
public class RegistrationForm {
    private String email;
    private String name;
    private String lastName;
    private String address;
    private String password;
    private String phoneNumber;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(email, name, lastName, address, passwordEncoder.encode(password), phoneNumber);
    }

    public RegistrationForm(String email, String name, String lastName, String address, String password, String phoneNumber) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.password = password;
        this.phoneNumber = phoneNumber;
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
