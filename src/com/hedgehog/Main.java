package com.hedgehog;

import java.util.Scanner;

import com.hedgehog.map.Map;
import com.hedgehog.vehicles.Vehicle;

public class Main {
	
	private static float interval;

    public static void main(String[] args) {
    	
    	Scanner scan = new Scanner(System.in);
        
    	System.out.println("Interval");
    		interval = scan.nextFloat();
    	while(true){
    		
    		System.out.println("Roads");
    		System.out.println("---Name");
    		String s = scan.next();
    		System.out.println("---Length");
    		float l = scan.nextFloat();
    		System.out.println("---Speedlimit");
    		float sp = scan.nextFloat();
    		System.out.println("---Safety");
    		float sa = scan.nextFloat();
    		
    		Map.addRoad(s, l, sp, sa);
    		
        	System.out.println("---Connections");
        	while(true){
            	System.out.println("---finished");
            	String in = scan.next();
        		if(in.equals("y")) break;
        		else{
        			System.out.println("---Connections");
        			System.out.println("---From Name");
        			in = scan.next();
        			if(Map.getRoad(in) == null) System.out.println("---invalid");
        			else Map.getRoad(in).addConnection(Map.getRoad(s)); 
        		}
        	}
        	
        	System.out.println("finished");
        	s = scan.next();
    		if(s.equals("y")) break;
    	}
    	
    	
    	System.out.println("Vehicles");
    	
    	System.out.println("---Amount");
    	int am = scan.nextInt();
    	Vehicle[] queue = new Vehicle[am];
    	System.out.println("---Random");
    	if(scan.next().equals("y"))	Map.queueRandom(am);
    	else Map.queue(am);

    	System.out.println("Runtime");
    	
    	int lim = scan.nextInt();
    	for(int loop = 0; loop < lim; loop++){
    		Map.updateAll(interval);
    	}
    	
    	scan.close();
    	Map.exit();
    }
}

/*
interval = (float) 0.2;

//System.out.println("Generating Map");
Map.generate();
//System.out.println("Adding Vehicles");
Map.addVehicle();
//System.out.println("Starting Calculartion"); 
for(int i = 0; i < 50; i++){
	Map.updateAll(interval);
}


//System.out.println("Adding Vehicles");
Map.addVehicle(new Car(0, 3, 5, 1, 0, 5));
for(int i = 0; i < 20; i++){
	Map.updateAll(interval);
}
//System.out.println("Adding Vehicles");
Map.addVehicle(new Car(0, 1, 2, 1, 0, 10));
for(int i = 0; i < 20; i++){
	Map.updateAll(interval);
}
//System.out.println("Adding Vehicles");
Map.addVehicle();
for(int i = 0; i < 20; i++){
	Map.updateAll(interval);
}
//System.out.println("Adding Vehicles");
Map.addVehicle(new Car(0, 3, 5, 1, 0, 5));
for(int i = 0; i < 20; i++){
	Map.updateAll(interval);
}
//System.out.println("Adding Vehicles");
Map.addVehicle(new Car(0, 1, 2, 1, 0, 10));
for(int i = 0; i < 20; i++){
	Map.updateAll(interval);
}
//System.out.println("Adding Vehicles");
Map.addVehicle();
for(int i = 0; i < 20; i++){
	Map.updateAll(interval);
}
//System.out.println("Adding Vehicles");
Map.addVehicle(new Car(0, 3, 5, 1, 0, 5));
for(int i = 0; i < 20; i++){
	Map.updateAll(interval);
}
//System.out.println("Adding Vehicles");
Map.addVehicle(new Car(0, 1, 2, 1, 0, 10));
for(int i = 0; i < 20; i++){
	Map.updateAll(interval);
}
//System.out.println("Adding Vehicles");
Map.addVehicle();
for(int i = 0; i < 20; i++){
	Map.updateAll(interval);
}
//System.out.println("Adding Vehicles");
Map.addVehicle(new Car(0, 3, 5, 1, 0, 5));
for(int i = 0; i < 20; i++){
	Map.updateAll(interval);
}
//System.out.println("Adding Vehicles");
Map.addVehicle(new Car(0, 1, 2, 1, 0, 10));
for(int i = 0; i < 20; i++){
	Map.updateAll(interval);
}
//System.out.println("Adding Vehicles");
Map.addVehicle();
for(int i = 0; i < 20; i++){
	Map.updateAll(interval);
}
//System.out.println("Adding Vehicles");
Map.addVehicle(new Car(0, 3, 5, 1, 0, 5));
for(int i = 0; i < 20; i++){
	Map.updateAll(interval);
}
//System.out.println("Adding Vehicles");
Map.addVehicle(new Car(0, 1, 2, 1, 0, 10));
for(int i = 0; i < 20; i++){
	Map.updateAll(interval);
}
//System.out.println("Adding Vehicles");
Map.addVehicle();
for(int i = 0; i < 20; i++){
	Map.updateAll(interval);
}


//System.out.println("Adding Vehicles");
Map.addVehicle(new Car(0, 10, 20, 0, 0, 20));
for(int i = 0; i < 1000; i++){
	Map.updateAll(interval);
}
System.out.println("Finished");
*/