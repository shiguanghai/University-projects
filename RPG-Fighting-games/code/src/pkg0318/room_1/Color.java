package pkg0318.room_1;

public abstract class Color extends Curtains {

	protected Curtains curtains;

	public Color(Curtains curtains){
		this.curtains=curtains;
	}

	public abstract String getDescription();

}
