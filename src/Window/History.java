package Window;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class History {
	private PrintWriter outputStream = null;
	private boolean rep = false;
	private String name,report;
	private int numOfOperation,numOfData;
	private boolean[] valid = new boolean[8];
	private ArrayList<Edition> editionList = new ArrayList<Edition>();
	private Law l;
	private boolean[] done = new boolean[8];
	private String[] comments = new String[8];
	
	public History(){
		for(int i = 0 ; i < 8 ; i++){
			comments[i] = "NONE";
		}
	}
	public String getName(){
		return name;
	}
	
	public int getNumOfOperation(){
		return numOfOperation;
	}
	
	public int getNumOfData(){
		return numOfData;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setNumOfOperation(int numOfOperation){
		this.numOfOperation = numOfOperation;
	}
	
	public void setNumOfData(int numOfData){
		this.numOfData = numOfData;
	}
	
	public boolean check(){
		for(int i=0;i<8;i++){
			if(done[i] == false){
				return false;
			}
		}
		return true;
	}

	public boolean getValid(int position){
		return valid[position];
	}
	
	public void setValid(int position, boolean value){
		this.valid[position] = value;
	}
	
	public boolean initEdition(String line){
		Edition e = new Edition();
		String[] words;
		words = line.split(";");
		try{
	        Integer.parseInt(words[0]);
	    }catch(NumberFormatException e1){
	        return false;
	    }
		int temp = Integer.parseInt(words[0]);
		e.setId(temp);
		String [] words2 = words[1].split("/");
		try{
	        Integer.parseInt(words2[0]);
	    }catch(NumberFormatException e1){
	        return false;
	    }
		try{
	        Integer.parseInt(words2[1]);
	    }catch(NumberFormatException e1){
	        return false;
	    }
		try{
	        Integer.parseInt(words2[2]);
	    }catch(NumberFormatException e1){
	        return false;
	    }
		temp = Integer.parseInt(words2[0]);
		int temp1 = Integer.parseInt(words2[1]);
		int temp2 = Integer.parseInt(words2[2]);
		e.setDate(temp2,temp1,temp);
		try{
	        Integer.parseInt(words[2]);
	    }catch(NumberFormatException e1){
	        return false;
	    }
		temp = Integer.parseInt(words[2]);
		e.setOpAdded(temp);
		try{
	        Integer.parseInt(words[3]);
	    }catch(NumberFormatException e1){
	        return false;
	    }
		temp = Integer.parseInt(words[3]);
		e.setOpDeleted(temp);
		try{
	        Integer.parseInt(words[4]);
	    }catch(NumberFormatException e1){
	        return false;
	    }
		temp = Integer.parseInt(words[4]);
		e.setOpUpdated(temp);
		try{
	        Integer.parseInt(words[5]);
	    }catch(NumberFormatException e1){
	        return false;
	    }
		temp = Integer.parseInt(words[5]);
		e.setDataAdded(temp);
		try{
	        Integer.parseInt(words[6]);
	    }catch(NumberFormatException e1){
	        return false;
	    }
		temp = Integer.parseInt(words[6]);
		e.setDataDeleted(temp);
		try{
	        Integer.parseInt(words[7]);
	    }catch(NumberFormatException e1){
	        return false;
	    }
		temp = Integer.parseInt(words[7]);
		e.setDataUpdated(temp);
		editionList.add(e);
		return true;
	}
	
	public String getReport(){
		return report;
	}
	
	public void setReport(String report){
			this.report = report;
			rep = true;
	}
	
	public void setComment(String com, int pos){
		comments[pos] = com;
	}
	
	public String getComment(int pos){
		return comments[pos];
	}
	
	public void initLaw(int num){
		if(num == 9){
			if(check() == false){
				reportError re = new reportError();
				re.setVisible(true);
				return;
			}
			else{
				if(rep == true){
					alreadyReport ar = new alreadyReport(this);
					ar.setVisible(true);
					return;
				}
				report rep = new report(this);
				rep.setVisible(true);
				return;
			}
		}
		if(done[num - 1] == true){
			if(valid[num - 1] == true){
				alreadyEvaluated v = new alreadyEvaluated("valid", this, num);
				v.setVisible(true);
				return;
			}
			else{
				alreadyEvaluated v = new alreadyEvaluated("invalid", this, num);
				v.setVisible(true);
				return;
			}
		}
		if(num == 7){
			if(done[1] == false || done[5] == false){
				seventhLawError el = new seventhLawError();
				el.setVisible(true);
				return;
			}
			else{
				if(valid[1] == true && valid[5] == true){
					valid[6] = true;
					l = new LawSeven();
					l.setTwoAndSix(true);
					l.valueLaw(this);
					done[6] = true;
					return;
				}
				else{
					valid[6] = false;
					l = new LawSeven();
					l.setTwoAndSix(false);
					l.valueLaw(this);
					done[6] = true;
					return;
				}
				
			}
		}
		if(num == 1){
			l = new LawOne();
			l.valueLaw(this);
		}
		else if(num == 2){
			l = new LawTwo();
			l.valueLaw(this);
		}
		else if(num == 3){
			l = new LawThree();
			l.valueLaw(this);
		}
		else if(num == 4){
			l = new LawFour();
			l.valueLaw(this);
		}
		else if(num == 5){
			l = new LawFive();
			l.valueLaw(this);
		}
		else if(num == 6){
			l = new LawSix();
			l.valueLaw(this);
		}
		else if(num == 8){
			l = new LawEight();
			l.valueLaw(this);
		}
		done[num - 1] = true;
	}
	
	public void undone(int pos){
		done[pos - 1] = false;
		comments[pos - 1] = "NONE";
	}
	
	public int getListSize(){
		return(editionList.size());
	}
	
	public Edition getEdition(int pos){
		return(editionList.get(pos));
	}
	
	public void saveReport(String r){
		String n = name + " - Report.txt";
		try
		{
			outputStream = new PrintWriter(new FileOutputStream(n));
		}
		catch(FileNotFoundException e)
		{
			System.out.printf("Problem opening files!!!\n");
			System.exit(0);
		}
		outputStream.println(r);
		outputStream.close();
	}
}
