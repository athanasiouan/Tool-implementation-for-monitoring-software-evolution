package Window;

public class LawSix extends Law{
	public void valueLaw(History h){
		//line
		int[] operation = new int [h.getListSize()];
		int[] data = new int [h.getListSize()];
		for(int i = 0 ; i < h.getListSize() ; i++){
			Edition temp = h.getEdition(i);
			if(i == 0){
				operation[i] = h.getNumOfOperation() - temp.getOpDeleted() + temp.getOpAdded();
				data[i] = h.getNumOfData() - temp.getDataDeleted() + temp.getDataAdded();
			}
			else{
				operation[i] = operation[i - 1] - temp.getOpDeleted() + temp.getOpAdded();
				data[i] = data[i - 1] - temp.getDataDeleted() + temp.getDataAdded();
			}
		}
		sixthLaw l = new sixthLaw(operation, data, h);
		l.pack();
        l.setVisible(true);		
	}
}
