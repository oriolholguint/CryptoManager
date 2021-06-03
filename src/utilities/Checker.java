package utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Oriol Holguin <oriolholguint@gmail.com>
 */
public class Checker 
{
    /**
     * Comprueba que el email cumpla con el patron indicado.
     * @param email correo electronico a comprobar.
     * @return TRUE = si cumple el patron.
     */
    public static boolean checkEmail(String email)
    {
        Pattern VALID_EMAIL_REGEX = Pattern.compile
        ("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_REGEX.matcher(email);
        return matcher.find();
    }
}
