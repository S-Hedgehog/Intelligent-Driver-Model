package com.hedgehog;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Export {

	private BufferedWriter writer = null;
	private int pre = 0;
	private String label;
	
	public Export(String s){
		label = s;
	}
	
	public void startWriter(){
		try{
			String name = label + ".txt";
			writer = new BufferedWriter(new FileWriter(name));
		}
		catch (IOException e){}
	}
	
	public void stopWriter(){
		try {if (writer != null) writer.close( );}
    	catch (IOException e){}	
	}

	public void newLine(){
		try{
			writer.newLine();
		}
		catch (IOException e){}
	}
	
	public void save(String s){
		for(int i = 0; i < pre; i++){
			s = "; ; " + s;
		}
		try{
			s = s.replace('.', ',');
			writer.write(s);
		}
		catch (IOException e){}
	}
	
	public void addPre(){
		pre++;
	}

	public void resetPre() {
		pre = 0;
		
	}
}
