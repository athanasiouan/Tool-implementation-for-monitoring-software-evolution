package Window;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Parser {

    private Scanner inputStream = null;
    private ArrayList<History> myList = new ArrayList<History>();
	
    public boolean init(String path){
        try
        {
            inputStream = new Scanner(new FileInputStream(path));
        }
        catch(FileNotFoundException e)
        {
            System.out.printf("Problem opening files!!!\n");
            System.exit(0);
        }
        String line = inputStream.nextLine();
        while(line.equals("")){
        	line = inputStream.nextLine();
        }
		String[] words;
		words = line.split(";");
		if(words[0].compareTo("Name") != 0){
			inputStream.close();
			errorFile2 er2 = new errorFile2();
			er2.setVisible(true);
			return false;
		}
        int pos = 0;
        boolean found = false;
        for(int i=0;i<myList.size();i++){
            History temp = myList.get(i);
            if(temp.getName().compareTo(words[1]) == 0){
                found = true;
                pos = i;
            }
        }
        if(found == false){
            History h = new History();
            h.setName(words[1]);
            line = inputStream.nextLine();
            while(line.equals("")){
            	line = inputStream.nextLine();
            }
    		words = line.split(";");
    		if(words[0].compareTo("Initial Number of Operations") != 0){
    			inputStream.close();
    			errorFile2 er2 = new errorFile2();
    			er2.setVisible(true);
    			return false;
    		}
    		try{
    	        Integer.parseInt(words[1]);
    	    }catch(NumberFormatException e1){
    	        return false;
    	    }
            int op = Integer.parseInt(words[1]);
            h.setNumOfOperation(op);
            line = inputStream.nextLine();
            while(line.equals("")){
            	line = inputStream.nextLine();
            }
    		words = line.split(";");
    		if(words[0].compareTo("Initial Number of Data Structures") != 0){
    			inputStream.close();
    			errorFile2 er2 = new errorFile2();
    			er2.setVisible(true);
    			return false;
    		}
    		try{
    	        Integer.parseInt(words[1]);
    	    }catch(NumberFormatException e1){
    	        return false;
    	    }
            int dt = Integer.parseInt(words[1]);
            h.setNumOfData(dt);
            line = inputStream.nextLine();
            while(line.equals("")){
            	line = inputStream.nextLine();
            }
    		words = line.split(";");
    		if(words.length != 8){
    			inputStream.close();
    			errorFile2 er2 = new errorFile2();
    			er2.setVisible(true);
    			return false;
    		}
            while(inputStream.hasNextLine()){
                line = inputStream.nextLine();
                while(line.equals("")){
                	line = inputStream.nextLine();
                }
        		words = line.split(";");
        		if(words.length != 8){
        			inputStream.close();
        			errorFile2 er2 = new errorFile2();
        			er2.setVisible(true);
        			return false;
        		}
                if(h.initEdition(line) == false){
        			inputStream.close();
        			errorFile2 er2 = new errorFile2();
        			er2.setVisible(true);
        			return false;
                }
            }
            myList.add(h);
        }
        else{
        	History temp = myList.get(pos);
            myList.remove(myList.get(pos));
            myList.add(temp);
        }
        inputStream.close();
        return true;
    }
	
    public void initLaw(int num){
    	History temp = myList.get(myList.size() - 1);
    	temp.initLaw(num);
    }
}