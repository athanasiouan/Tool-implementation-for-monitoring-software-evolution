package Window;

public class LawEight extends Law{
	public void valueLaw(History h){
		//real
		int[] operation = new int [h.getListSize()];
		for(int i = 0 ; i < h.getListSize() ; i++){
			Edition temp = h.getEdition(i);
			if(i == 0){
				operation[i] = h.getNumOfOperation() - temp.getOpDeleted() + temp.getOpAdded();
			}
			else{
				operation[i] = operation[i - 1] - temp.getOpDeleted() + temp.getOpAdded();
			}
		}
		//ektimisi
		double[] estimation = new double [h.getListSize()];
		double ej = 0.0, sumej = 0.0, sume = 0.0;
		for(int i = 0 ; i < h.getListSize() ; i++){
			for(int j = 1 ; j < i ; j++){
				for(int k = 1; k < j - 1 ; k++){
					Edition temp = h.getEdition(k);
					sumej += (1/(double)Math.pow(operation[k] - temp.getOpDeleted() + temp.getOpAdded(),2));
				}
				if(sumej != 0){
					ej += ((operation[j] - operation[0])/(double)sumej);
				}
				sume += (ej/(double)i);
			}
			Edition temp = h.getEdition(i);
			estimation[i] = operation[i] + (sume/(double)Math.pow(operation[i],2));
		}
		eighthLaw l = new eighthLaw(operation, estimation, h);
		l.pack();
        l.setVisible(true);	
	}
}

