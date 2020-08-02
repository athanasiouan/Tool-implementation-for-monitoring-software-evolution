package Window;

public class LawSeven extends Law{
	private boolean choice;
	
	public void valueLaw(History h){
		if(choice == true){
			seventhLaw l = new seventhLaw(h);
			l.setVisible(true);
		}
		else{
			seventhLawNotValid l = new seventhLawNotValid(h);
			l.setVisible(true);
		}
	}
	
	public void setTwoAndSix(boolean choice){
		this.choice = choice;
	}
}
