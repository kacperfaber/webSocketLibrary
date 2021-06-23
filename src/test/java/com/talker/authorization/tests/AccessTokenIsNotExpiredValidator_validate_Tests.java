package com.talker.authorization.tests;

import com.talker.websocketlibrary.authorization.AccessNotIsNotExpiredValidator;
import com.talker.websocketlibrary.authorization.AccessToken;
import com.talker.websocketlibrary.commons.IServerDateTimeProvider;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDateTime;

public class AccessTokenIsNotExpiredValidator_validate_Tests {
    IServerDateTimeProvider timeProvider;

    public AccessTokenIsNotExpiredValidator_validate_Tests() {
        timeProvider = Mockito.mock(IServerDateTimeProvider.class);
    }

    boolean exec(AccessToken accessToken) {
        AccessNotIsNotExpiredValidator validator = new AccessNotIsNotExpiredValidator();
        return validator.validate(accessToken);
    }

    @Test
    public void trueIfIsNotOldestThan15() {
        Mockito.when(timeProvider.provide()).thenReturn(LocalDateTime.of(2020, 12, 6, 12, 0));
        exec(new AccessToken() {{ setAuthenticatedAt(LocalDateTime.of(2020, 12, 6, 12, 0)); }});
    }

    @Test
    public void falseIfOldestThan15() {
        Mockito.when(timeProvider.provide()).thenReturn(LocalDateTime.of(2020, 12, 6, 12, 30));
        exec(new AccessToken() {{ setAuthenticatedAt(LocalDateTime.of(2020, 12, 6, 12, 0)); }});
    }
}
