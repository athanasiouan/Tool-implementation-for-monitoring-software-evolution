package Window;

public class LawTwo extends Law{
	public void valueLaw(History h){
		//line
		float[] operationComplexity = new float [h.getListSize()];
		float[] dataComplexity = new float [h.getListSize()];
		for(int i = 0 ; i < h.getListSize() ; i++){
			Edition temp = h.getEdition(i);
			operationComplexity[i] = temp.computeOperationComplexity();
			dataComplexity[i] = temp.computeDataComplexity();
		}
		
		//bar
		int[] maintenance = new int [h.getListSize()];
		for(int i = 0 ; i < h.getListSize() ; i++){
			Edition temp = h.getEdition(i);
			maintenance[i] = temp.getOpDeleted() + temp.getOpAdded() + temp.getOpUpdated() + temp.getDataAdded() + temp.getDataDeleted() + temp.getDataUpdated();
		}
		secondLaw l = new secondLaw(maintenance, operationComplexity, dataComplexity, h);
		l.pack();
        l.setVisible(true);
	}
}