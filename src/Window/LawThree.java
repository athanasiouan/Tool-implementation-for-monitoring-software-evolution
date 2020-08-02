package Window;

public class LawThree extends Law{
	public void valueLaw(History h){
		//line
		int[] operation = new int [h.getListSize()];
		int[] data = new int [h.getListSize()];
		for(int i = 0 ; i < h.getListSize() ; i++){
			Edition temp = h.getEdition(i);
			operation[i] = h.getNumOfOperation() + temp.computeOperationGrowth();
			operation[i] = operation[i] - h.getNumOfOperation();
			data[i] = h.getNumOfData() + temp.computeDataGrowth();
			data[i] = data[i] - h.getNumOfData();
		}
		thirdLaw l = new thirdLaw(operation, data, h);
		l.pack();
        l.setVisible(true);
	}
}