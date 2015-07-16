package com.hedgehog;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.hedgehog.map.Map;

/**
 * Created by Hedgehog on 04.07.2015.
 */

public class Main {
	
	private static float interval;

    public static void main(String[] args) {
    	
    	Scanner scan = new Scanner(System.in);
        
    	System.out.println("Please provide delta t for the calculation (interval in seconds).");
    		interval = 0;
    		while(interval<=0){
    			try{
    				interval = scan.nextFloat();
    			}
    			catch(InputMismatchException e){
    				System.out.println("Please insert a float that is bigger than zero.");
    				scan.next();
    			}
    		}
    	while(true){
    		
    		System.out.println("Provide information for road network");
    		System.out.println("---Insert road name.");
    		String s = scan.next();
    		System.out.println("---Provide length of the road as float. (meter)");
    		float l = 0;
    		while(l<=0){
    			try{
    				l = scan.nextFloat();
    			}
    			catch(InputMismatchException e){
    				System.out.println("Please insert a float that is bigger than zero.");
    				scan.next();
    			}
    		}
    		System.out.println("---The Speedlimit for the current Road is? (meter per second)");
    		float sp = 0;
    		while(sp<=0){
    			try{
    				sp = scan.nextFloat();
    			}
    			catch(InputMismatchException e){
    				System.out.println("Please insert a float that is bigger than zero.");
    				scan.next();
    			}
    		}
    		System.out.println("---Cars have the following distance to each other while in rest. (meter)");
    		float sa= 0;
    		while(sa<=0){
    			try{
    				sa = scan.nextFloat();
    			}
    			catch(InputMismatchException e){
    				System.out.println("Please insert a float that is bigger than zero.");
    				scan.next();
    			}
    		}
    		
    		Map.addRoad(s, l, sp, sa);
    		
        	System.out.println("---Pleas provide information regarding the connection of the current roads with other roads.");
        	while(true){
            	System.out.println("---Do you want to add a connection?(y/n)");
            	String in = scan.next();
        		if(in.equals("n")) break;
        		
        		System.out.println("---From another road to this one??(y/n)");
            	in = scan.next();
            	
        		if(in.equals("y")){
        			System.out.println("------Name of the other road");
        			in = scan.next();
        			if(Map.getRoad(in) == null) System.out.println("------No road with the given name found in the list of existing roads. Exiting current request.");
        			else{
        				Map.getRoad(in).addConnection(Map.getRoad(s)); 
        				System.out.println("------Connection established.");
        			}
        		}

        		System.out.println("---From this road to another one??(y/n)");
            	in = scan.next();
        		if(in.equals("y")){
        			System.out.println("------Name of the other road");
        			in = scan.next();
        			if(Map.getRoad(in) == null) System.out.println("------No road with the given name found in the list of existing roads. Exiting current request.");
        			else{
        				Map.getRoad(s).addConnection(Map.getRoad(in)); 
        				System.out.println("------Connection established.");
        			}
        		}
        		
        	}
        	
        	System.out.println("---Do you want to add another road? (y/n)");
        	s = scan.next();
    		if(s.equals("n")) break;
    	}
    	
    	
    	System.out.println("Pleas provide information about the vehicles that are supposed to spawn.");
    	
    	System.out.println("---Specify Amount");
    	int am = 0;
    	while(am<=0){
			try{
				am = scan.nextInt();
			}
			catch(InputMismatchException e){
				System.out.println("---Please insert an integer that is bigger than zero.");
				scan.next();
			}
    	}
    	System.out.println("---Shall they have semi-random probabilities (standard values otherwise)? (y/n)");
    	if(scan.next().equals("y"))	Map.queueRandom(am);
    	else Map.queue(am);

    	System.out.println("Please specify how many iterations you want to calculate");
    	
    	int lim = 0;
    	while(lim<=0){
			try{
				lim = scan.nextInt();
			}
			catch(InputMismatchException e){
				System.out.println("Please insert an integer that is bigger than zero.");
				scan.next();
			}
    	}
    	
    	
    	for(int loop = 0; loop < lim; loop++){
    		Map.updateAll(interval);
    	}
    	
    	System.out.println("Finished calculation.");
    	scan.close();
    	System.out.println("Closing scanner.");
    	Map.exit();
    	System.out.println("Closing buffered writers.");
    	System.out.println("Done.");
    }
}