package sn.ipmridwwan.model;

import org.junit.jupiter.api.Test;

import javax.security.auth.callback.Callback;

import static org.junit.jupiter.api.Assertions.*;

class UserLoginModuleCallbackHandlerTest {

    @Test
    void handleTest() {
        UserLoginModuleCallbackHandler user = new UserLoginModuleCallbackHandler();
        user.handle();
    }
}