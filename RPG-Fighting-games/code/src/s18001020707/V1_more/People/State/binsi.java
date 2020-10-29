package s18001020707.V1_more.People.State;

import s18001020707.V1_more.People.Role;

public class binsi implements State {

    private String state="±ÙÀ¿";

    @Override
    public int doATK(Role role) {
        return (int)(role.getAtk()*1.2);
    }

    @Override
    public String toString() {
        return state;
    }
}
