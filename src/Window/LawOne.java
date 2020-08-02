package Window;

public class LawOne extends Law{
	
	public void valueLaw(History h){
		//bar 3
		Edition temp = h.getEdition(0);
		int min = temp.getYear();
		temp = h.getEdition(h.getListSize() - 1);
		int max = temp.getYear();
		int[] counter = new int [max - min + 1];
		for(int i = 0 ; i < h.getListSize() ; i++){
			temp = h.getEdition(i);
			counter[temp.getYear() - min]++;
		}		
		//bar 1 kai 2
		int[] numOfOperation = new int [h.getListSize()];
		int[] numOfData = new int [h.getListSize()];
		for(int i = 0 ; i < h.getListSize() ; i++){
			temp = h.getEdition(i);
			numOfOperation[i] = temp.getOpAdded() + temp.getOpDeleted() + temp.getOpUpdated();
			numOfData[i] = temp.getDataAdded() + temp.getDataDeleted() + temp.getDataUpdated();
		}
		firstLaw l = new firstLaw(numOfOperation, numOfData, counter, min, max, h);
		l.pack();
        l.setVisible(true);
	}
}