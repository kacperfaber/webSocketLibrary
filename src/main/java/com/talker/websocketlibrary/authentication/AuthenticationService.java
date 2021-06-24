package com.talker.websocketlibrary.authentication;

import com.talker.websocketlibrary.database.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class AuthenticationService {
    public IPasswordHasher passwordHasher;
    public SessionFactory sessionFactory;

    public AuthenticationService(IPasswordHasher passwordHasher, SessionFactory sessionFactory) {
        this.passwordHasher = passwordHasher;
        this.sessionFactory = sessionFactory;
    }

    public AuthenticationResult authenticate(String usernameOrEmail, String password) {
        String passwordHash = passwordHasher.hash(password);

        HashMap<String, String> properties = new HashMap<>() {{
            put("passwordHash", passwordHash);
            put("usernameOrEmail", usernameOrEmail);
        }};

        User user = sessionFactory
                .getCurrentSession()
                .createQuery("from User where (username = :usernameOrEmail or email = :usernameOrEmail) and passwordHash = :passwordHash", User.class)
                .setProperties(properties)
                .getSingleResult();

        if (user == null) {
            return new AuthenticationResult(false, null);
        }

        return new AuthenticationResult(true, user.getId());
    }
}
