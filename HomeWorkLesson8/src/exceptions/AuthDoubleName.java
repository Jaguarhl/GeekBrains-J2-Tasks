package exceptions;

/**
 * Created by Jag on 31.10.2016.
 */
public class AuthDoubleName extends AuthFailException {
    private String nickname;

    public AuthDoubleName(String nick) {
        super();
        this.nickname = nick;
    }
}
