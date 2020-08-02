package Window;

public class LawFive extends Law{
	public void valueLaw(History h){
		//line
		int[] operation = new int [h.getListSize()];
		int[] data = new int [h.getListSize()];
		for(int i = 0 ; i < h.getListSize() ; i++){
			Edition temp = h.getEdition(i);
			operation[i] = temp.computeOperationGrowth();
			data[i] = temp.computeDataGrowth();
		}
		fifthLaw l = new fifthLaw(operation, data, h);
		l.pack();
		l.setVisible(true);
	}
}
