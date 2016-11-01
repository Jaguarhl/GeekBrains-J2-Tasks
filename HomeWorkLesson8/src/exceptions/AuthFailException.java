package exceptions;

/**
 * Created by Tim on 13.09.2016.
 */
public class AuthFailException extends Exception {
    static private final String AUTH_ERROR = "Authorisation error";

    public String getFailInfo() {
        return AUTH_ERROR;
    }
}
