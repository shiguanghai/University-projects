package s18001020707.V1_more.People.State;

import s18001020707.V1_more.People.Role;

public class Health implements State{

    private String state="½¡¿µ";

    @Override
    public int doATK(Role role) {
        return role.getAtk();
    }

    @Override
    public String toString() {
        return state;
    }
}
