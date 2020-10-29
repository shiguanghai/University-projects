package pkg0410.cagegui.view;

import java.awt.Color;

public class BarFactory {
	public static BarPanel createBarPanel(Color color) {
		return new BarPanel(color);
	}
	
	public static BarPanel createBarPanel(Color color,int i) {
		return new BarDecarator(i,new BarPanel(color));
	}
	
	public static BarPanel createBarPanel(int i,Color color) {
		return new BarDecarator(i,new BarPanel(color));
	}
}
