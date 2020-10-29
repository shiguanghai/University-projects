package s18001020707.V1_more;

import s18001020707.V1_more.Controller.GameController;

import java.lang.reflect.InvocationTargetException;

public class main {
    public static void main(String args[]) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
//        emei e=new emei();
//        shaolin s=new shaolin();
//        String username="Ï¼Ö®ÇðÊ«ÓðÁ¹ÁË";
//        Role r=Role.getRole(username,s);
//        System.out.println(r.toString());
//        r.setCurrenthp(10);
//        System.out.println(r.attack(r.getRoleSkill().get(0)));
        GameController gameController=new GameController();
        gameController.gogame();

    }
}
