package s18001020707.V4.model.People.State;

import s18001020707.V4.model.People.Role;

public class Health implements State {

    private String state="����";

    @Override
    public int doATK(Role role) {
        return role.getAtk();
    }

    @Override
    public String toString() {
        return state;
    }
}
