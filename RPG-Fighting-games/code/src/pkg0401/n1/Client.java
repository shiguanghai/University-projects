package pkg0401.n1;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        TVFactory tv1 = new TVFactory();
        TVFactory tv2 = new TVFactory();
        try {
            tv1.produceTV("Haier");
            tv2.produceTV("Changhong");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
