package pkg0327.cagegui.v3.view;

import java.awt.*;

public class BarFactory {
    public static BarPanel createBarPanel(Color color){
        return new BarPanel(color);
    }

    public static BarPanel createBarPanel(Color color,int i){
        return new BarDecarator(i,new BarPanel(color));
    }

    public static BarPanel createBarPanel(int i,Color color){
        return new BarDecarator(i,new BarPanel(color));
    }
}
