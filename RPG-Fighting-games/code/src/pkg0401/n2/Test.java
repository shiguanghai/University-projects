package pkg0401.n2;

public class Test {
    public static void main(String[] args) {
        AnimalFactory af =new AnimalFactory();

        Animal a1 = af.getAnimal("����");
        Animal a2 = af.getAnimal("�¸�");

        a1.voice();
        a2.voice();
    }

}
