package us.cijian.autumn.exception;

/**
 * Created by MurphyL on 5/24/2015.
 */
public class NoPrivilegesException extends Exception {

    private boolean authenticated;

    public NoPrivilegesException(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }
}
