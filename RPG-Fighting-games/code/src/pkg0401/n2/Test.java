package pkg0401.n2;

public class Test {
    public static void main(String[] args) {
        AnimalFactory af =new AnimalFactory();

        Animal a1 = af.getAnimal("ß÷ß÷");
        Animal a2 = af.getAnimal("¸Â¸Â");

        a1.voice();
        a2.voice();
    }

}
