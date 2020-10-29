package s18001020707.V3_Observer_Strategy_State.People.State;

import s18001020707.V3_Observer_Strategy_State.People.Role;

public class binsi implements State {

    private String state="±ÙÀ¿";

    @Override
    public int doATK(Role role) {
        return (int)(role.getAtk()*1.5);
    }

    @Override
    public String toString() {
        return state;
    }
}
