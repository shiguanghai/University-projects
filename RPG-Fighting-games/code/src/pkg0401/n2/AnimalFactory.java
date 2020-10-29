package pkg0401.n2;

public class AnimalFactory {


	public Animal getAnimal(String type) {
		if("ß÷ß÷".equals(type)){
			return new Cat();
		}else if("¸Â¸Â".equals(type)){
			return new Duck();
		}else{
			return null;
		}
	}

}
