package com.hedgehog.map;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import com.hedgehog.vehicles.Car;
import com.hedgehog.vehicles.Vehicle;

/**
 * Created by Hedgehog on 04.07.2015.
 */

public class Map {
	
	private static ArrayList<Road> roads = new ArrayList<Road>();
	private static LinkedList<Vehicle> queue = new LinkedList<Vehicle>();
	
	public static void updateAll(float i){
		if(queue.size() != 0){
			if(roads.get(0).addVehicle(queue.getFirst())){
				queue.removeFirst();
			}
		}
		for(Road r1: roads){
			r1.updateAll(i);
		}	
	}

	public static float getMinDistance(Vehicle v) {
		Road rTemp = findVehicle(v);
		if(rTemp != null) return rTemp.getSafetyDistance();
		return 2;
	}

	public static float getSpeedlimit(Vehicle v) {
		Road rTemp = findVehicle(v);
		if(rTemp != null) return rTemp.getSpeedLimit();
		return 15;
	}
	
	public static Road findVehicle(Vehicle v){
		for(Road r1: roads){
			if(r1.contains(v)) return r1;
		}		
		return null;
	}
	
	public static boolean addVehicle(Vehicle v, Road r){
		return r.addVehicle(v);
	}
	
	public static boolean addVehicle(Vehicle v){
		return addVehicle(v, roads.get(0));
	}
	
	public static boolean addVehicle(){
		return addVehicle(new Car());
	}
	
	public static void exit(){
		for(Road r1 : roads){
			r1.stop();
		}
	}
	
	public static Road getRoad(String label){
		for(Road r1: roads){
			if(r1.getLabel().equals(label)) return r1;
		}
		return null;
	}

	public static void addRoad(String s, float l, float sp, float sa) {
		roads.add(new Road(s, l, sp, sa));		
	}

	public static void queueRandom(int am) {
		for(int i = 0; i < am; i++){
			Random r = new Random();
			queue.add(new Car(0, (6*r.nextFloat()+1), (4*r.nextFloat()+3), (2*r.nextFloat()), 0, (8*r.nextFloat()-2)));
		}
	}

	public static void queue(int am) {
		for(int i = 0; i < am; i++){
			queue.add(new Car());
		}	
	}
	
}
