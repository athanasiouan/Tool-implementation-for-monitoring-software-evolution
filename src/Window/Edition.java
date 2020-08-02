package Window;

public class Edition {
	private int id,operationAdded,dataAdded,operationDeleted,dataDeleted,operationUpdated,dataUpdated;
	private int year,month,day;
	
	public float computeOperationComplexity(){
		if (operationAdded == 0){
			return 0;
		}
		return (operationUpdated + operationDeleted)/(float)operationAdded;
	}
	
	public float computeDataComplexity(){
		if (dataAdded == 0){
			return 0;
		}
		return (dataUpdated + dataDeleted)/(float)dataAdded;
	}
	
	public double computeOperationWorkRate(Edition other){
		int day1 = this.getDay();
		int day2 = other.getDay();
		int month1 = this.getMonth();
		int month2 = other.getMonth();
		int year1 = this.getYear();
		int year2 = other.getYear();
		int d, m, y;
		if(day2>=day1){
		    d = day2 - day1;
		    if(month2>=month1){
			    m = month2 - month1;
			    y = year2 - year1;
			}
		    else{
		    	m = (12 - month1) + month2;
				y = year2 - year1 - 1;
		    }
		    
		}
		else
		{
			d = (30 - day1) + day2;
			if(month1-month>0){
				m = month1 - month - 1;
				y = year2 - year1;
			}
			else{
				m = (12 - month1) + month2 - 1;
				y = year2 - year1 - 1;
			}
		}
		return (operationAdded + operationDeleted + operationUpdated) / (float)(y * 365 + m * 30.5 + d);
	}
	
	public float computeDataWorkRate(Edition other){
		int day1 = this.getDay();
		int day2 = other.getDay();
		int month1 = this.getMonth();
		int month2 = other.getMonth();
		int year1 = this.getYear();
		int year2 = other.getYear();
		int d, m, y;
		if(day2>=day1){
		    d = day2 - day1;
		    if(month2>=month1){
			    m = month2 - month1;
			    y = year2 - year1;
			}
		    else{
		    	m = (12 - month1) + month2;
				y = year2 - year1 - 1;
		    }
		    
		}
		else
		{
			d = (30 - day1) + day2;
			if(month1-month>0){
				m = month1 - month - 1;
				y = year2 - year1;
			}
			else{
				m = (12 - month1) + month2 - 1;
				y = year2 - year1 - 1;
			}
		}
		return (dataAdded + dataDeleted + dataUpdated) / (float)(y * 365 + m * 30 + d);
	}
	
	
	public int computeOperationGrowth(){
		return operationAdded - operationDeleted;
	}
	
	public int computeDataGrowth(){
		return dataAdded - dataDeleted;
	}
	
	public int getId(){
		return id;
	}
	
	public int getDay(){
		return day;
	}
	
	public int getMonth(){
		return month;
	}
	
	public int getYear(){
		return year;
	}
	
	public int getOpAdded(){
		return operationAdded;
	}
	
	public int getOpDeleted(){
		return operationDeleted;
	}
	
	public int getOpUpdated(){
		return operationUpdated;
	}
	
	public int getDataAdded(){
		return dataAdded;
	}
	
	public int getDataDeleted(){
		return dataDeleted;
	}
	
	public int getDataUpdated(){
		return dataUpdated;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setDate(int year, int month, int day){
		this.day = day;
		this.year = year;
		this.month = month;
	}
	
	public void setOpAdded(int operationAdded){
		this.operationAdded = operationAdded;
	}
	
	public void setOpDeleted(int operationDeleted){
		this.operationDeleted = operationDeleted;
	}
	
	public void setOpUpdated(int operationUpdated){
		this.operationUpdated = operationUpdated;
	}
	
	public void setDataAdded(int dataAdded){
		this.dataAdded = dataAdded;
	}
	
	public void setDataDeleted(int dataDeleted){
		this.dataDeleted = dataDeleted;
	}
	
	public void setDataUpdated(int dataUpdated){
		this.dataUpdated = dataUpdated;
	}
	
}