package Window;

public abstract class Law {
	private boolean valid, choice;
	private String comment;
	
	public boolean isValid(){
		return valid;
	}
	
	public void setComment(String comment){
		this.comment = comment;
	}
	
	public String getComment(){
		return comment;
	}
	
	public void setTwoAndSix(boolean choice){
		this.choice = choice;
	}
	
	public abstract void valueLaw(History h);
}
