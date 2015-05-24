package us.cijian.autumn.module;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MurphyL on 5/24/2015.
 */
public enum Privileges {

    Owner(),
    Admin(),
    Register();

    private List<String> roles;

    Privileges() {
        this.roles = new ArrayList<String>();
    }

    public void add(String role) {
        roles.add(role);
    }

    public List<String> getRoles() {
        return roles;
    }
}
