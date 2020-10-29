package s18001020707.V3_Observer_Strategy_State;

import s18001020707.V3_Observer_Strategy_State.Controller.GameController;

import java.lang.reflect.InvocationTargetException;

public class main {
    public static void main(String args[]) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        GameController gameController=new GameController();
        gameController.gogame();

    }
}
