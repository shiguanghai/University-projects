package pkg0401.n2;

public class AnimalFactory {


	public Animal getAnimal(String type) {
		if("����".equals(type)){
			return new Cat();
		}else if("�¸�".equals(type)){
			return new Duck();
		}else{
			return null;
		}
	}

}
