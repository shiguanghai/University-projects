package pkg0318.room_1;

public class AssortedColor extends Color {

	public AssortedColor(Curtains curtains){
		super(curtains);
	}

	public String getDescription() {
		return curtains.getDescription() + " with AssortedColor";
	}

}
