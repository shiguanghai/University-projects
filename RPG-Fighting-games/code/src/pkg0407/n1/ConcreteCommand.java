package pkg0407.n1;

public class ConcreteCommand implements Command {

	CompanyArmy army;

	ConcreteCommand(CompanyArmy army){
		this.army=army;
	}


	public void execute() {
		army.sneakAttack();
	}

}
