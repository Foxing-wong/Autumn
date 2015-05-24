package us.cijian.autumn.constants;

import java.util.Arrays;
import java.util.List;

/**
 * Created by MurphyL on 5/24/2015.
 */
public enum Privileges {

    Owner("Owner", "Admin", "Register"),
    Admin("Admin", "Register"),
    Register("Register");

    private List<String> roles;

    Privileges(String... roles) {
        this.roles = Arrays.asList(roles);
    }

    public List<String> getRoles() {
        return roles;
    }
}
