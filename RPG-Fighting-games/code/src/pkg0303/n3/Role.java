package pkg0303.n3;

public interface Role {
    Role STUDENT = new Student();
    Role CASHIER = new Cashier();
    Role ASSISTANT = new Assistant();

    void action();
}
