package Window;

public class LawFour extends Law{
	public void valueLaw(History h){
		double[] operation = new double [h.getListSize()];
		double[] data = new double [h.getListSize()];
		for(int i = 0 ; i < h.getListSize() - 1 ; i++){
			Edition temp = h.getEdition(i);
			operation[i] = temp.computeOperationWorkRate(h.getEdition(i + 1));
			data[i] = temp.computeDataWorkRate(h.getEdition(i + 1));
		}
		fourthLaw l = new fourthLaw(operation, data, h);
		l.pack();
        l.setVisible(true);
	}
}