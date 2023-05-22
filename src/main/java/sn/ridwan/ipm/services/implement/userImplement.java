package sn.ridwan.ipm.services.implement;

import at.favre.lib.crypto.bcrypt.BCrypt;
import sn.ridwan.ipm.services.interfaces.userInterface;

public  class userImplement implements userInterface {
    @Override
    public String HashDefaultPassword(String plainPassword) {
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, plainPassword.toCharArray());
        return bcryptHashString;
    }
}
