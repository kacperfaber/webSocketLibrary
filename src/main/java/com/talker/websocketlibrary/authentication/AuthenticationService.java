package com.talker.websocketlibrary.authentication;

import com.talker.websocketlibrary.database.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class AuthenticationService {
    public IPasswordHasher passwordHasher;
    public SessionFactory sessionFactory;

    public AuthenticationService(IPasswordHasher passwordHasher, SessionFactory sessionFactory) {
        this.passwordHasher = passwordHasher;
        this.sessionFactory = sessionFactory;
    }

    public AuthenticationResult authenticate(String usernameOrEmail, String password) {
        if (usernameOrEmail.equals("kacper")) {
            return new AuthenticationResult(true, usernameOrEmail);
        }
        return new AuthenticationResult(false, null);

//        String passwordHash = passwordHasher.hash(password);
//
//        HashMap<String, String> properties = new HashMap<>() {{
//            put("passwordHash", passwordHash);
//            put("usernameOrEmail", usernameOrEmail);
//        }};
//
//        Session session = sessionFactory
//                .getCurrentSession();
//
//        session.beginTransaction();
//
//        List<User> users = session
//                .createQuery("from User where (upper(username) = upper(:usernameOrEmail) or upper(email) = upper(:usernameOrEmail)) and passwordHash = :passwordHash", User.class)
//                .setProperties(properties)
//                .getResultList();
//
//        if (users.isEmpty()) {
//            return new AuthenticationResult(false, null);
//        }
//
//        return new AuthenticationResult(true, users.stream().findFirst().get().getId());
    }
}
