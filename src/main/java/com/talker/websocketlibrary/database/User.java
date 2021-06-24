package com.talker.websocketlibrary.database;

import java.util.Objects;

public class User {
    private String email;
    private String username;
    private String passwordHash;
    private String displayName;
    private String id;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) && Objects.equals(username, user.username) && Objects.equals(passwordHash, user.passwordHash) && Objects.equals(displayName, user.displayName) && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, username, passwordHash, displayName, id);
    }
}
