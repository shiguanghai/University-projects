package pkg0303.n3;

public class Person {
    private Role role;

    public Person(){
        role = Role.STUDENT;
    }
    public Role getRole(){
        return role;
    }
    public void setRole(Role role){
        this.role=role;
    }
    public void action(){
        role.action();
    }
}
