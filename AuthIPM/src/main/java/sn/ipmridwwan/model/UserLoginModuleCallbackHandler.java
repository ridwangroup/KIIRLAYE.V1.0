package sn.ipmridwwan.model;

import javax.security.auth.callback.*;
import java.io.Console;
import java.io.IOException;
/*@UserLoginModuleCallbackHandler
*       collecte les informations d'identifiant de l'utilisateur
*       */
public class UserLoginModuleCallbackHandler implements CallbackHandler {
    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        Console console = System.console();
        for (Callback callback : callbacks){
           if(callback instanceof NameCallback){
               NameCallback nameCallback = (NameCallback) callback;
               nameCallback.setName(console.readLine(nameCallback.getPrompt()));
           }
           else if(callback instanceof PasswordCallback){
               PasswordCallback passwordCallback = (PasswordCallback) callback;
               passwordCallback.setPassword();
           }
        }
    }
}
