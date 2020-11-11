package pl.miknow.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.miknow.library.dao.UserRepository;
import pl.miknow.library.validation.FieldValueExists;

@Service
public class UserService implements FieldValueExists {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean fieldValueExists(Object value, String fieldName) throws UnsupportedOperationException {

        if (!fieldName.equals("email")) {
            throw new UnsupportedOperationException("Field name not supported");
        }

        if (value == null) {
            return false;
        }

        return this.userRepository.findByUsername(value.toString()) != null;
    }
}
