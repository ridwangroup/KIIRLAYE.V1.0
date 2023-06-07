package sn.ridwan.security.helpers;

import at.favre.lib.crypto.bcrypt.BCrypt;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.security.SignatureException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorHelper {

   static final String SECRET_KEY=" ";
    private static final String EMAIL_PATTERN ="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
    private static final String TELEPHONE_PATTERN = "^(221|00221|\\+221)?(77|78|75|70|76)[0-9]{7}$";
    private static final String USERIDD_PATTERN = "^(MAT-|RIDCA-).*";

    private static final Pattern patternTel = Pattern.compile(TELEPHONE_PATTERN);
    private static final Pattern patternEmail = Pattern.compile(EMAIL_PATTERN,Pattern.CASE_INSENSITIVE);
    private static final Pattern patternUserIdd = Pattern.compile(USERIDD_PATTERN);

    public static boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
        //Matcher matcher = patternEmail.matcher(email);
        //return matcher.matches();
    }

/*    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
*/


    public static Claims decodeToken(String token) throws SignatureException {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    public static boolean isTokenExpired(Claims claims) {
        return claims.getExpiration().before(new Date());
}
    public static String SecretKey() {
        String SECRET_KEY="odKAmV6AbsoWsyL3thUoYVDEJAsQl8RrH+JuQ9HWUnDLunDdLEM6oNl15XP1xLOHz3bEq1rvATiQmAByKNOiVujd1gsq7JxfQYDdHRzDhZZrUstnetvGTDBtMHmhzbBX";
    return SECRET_KEY;
    }

    public static long milliSecond() {
        long millisecond= 60000;
        return millisecond;
    }
    public static boolean validateTelephone(String telephone) {
        Matcher matcher = patternTel.matcher(telephone);
        return matcher.matches();
    }

    public static boolean validateUserIdd(String userIdd) {
        Matcher matcher = patternUserIdd.matcher(userIdd);
        return matcher.matches();
    }

    public static boolean validateLogin(String username) {

        if (validateEmail(username)) {

            return true;
        }
        if (validateTelephone(username)) {

            return true;
        }
        validateUserIdd(username);
        return true;
    }

    public static String HashPlainPassword(String plainPassword) {
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, plainPassword.toCharArray());
        return bcryptHashString;
    }

    public static BCrypt.Result ComparePassword(String plainPassword, String bcryptHashString){
        BCrypt.Result result = BCrypt.verifyer().verify(plainPassword.toCharArray(), bcryptHashString);
        return result;
    }

    public static String getLoginType(String login){
        if(login.contains("@")){
           return "email";
        }
        if(login.startsWith("MAT") || (login.startsWith("RIDCA"))){
           return "userId";
        }
        if(login.startsWith("70") || login.startsWith("75") || login.startsWith("76") || login.startsWith("77") || login.startsWith("78")){
           return "telephone";
        }
        return null;
    }

    public static String createSQLLoginQuery(String login){
        String loginType = getLoginType(login);
        if(loginType!=null){
            String tmpQuery="Select user From User user Where user.isEtat=:true";
            if(loginType == "email"){
                return tmpQuery + " AND user.email=:login";
            }
            if(loginType == "userId"){
                return tmpQuery + " AND user.userIdd=:login";
            }
            if(loginType == "telephone"){
                return tmpQuery + " AND user.tel=:login";
            }
        }
        return null;
    }
}