package pkg0318.room_1;

public class PureColor extends Color {
	public PureColor(Curtains curtains){
		super(curtains);
	}

	public String getDescription() {
		return curtains.getDescription() + " with PureColor";
	}

}
