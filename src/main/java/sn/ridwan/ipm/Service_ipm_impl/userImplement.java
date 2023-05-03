package sn.ridwan.ipm.Service_ipm_impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import sn.ridwan.ipm.service_ipm_interfaces.userInterface;

public  class userImplement implements userInterface {
    @Override
    public String checkPassword(String plainPassword) {
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, plainPassword.toCharArray());
        return bcryptHashString;
    }
}
