package com.hedgehog.map;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import com.hedgehog.Export;
import com.hedgehog.vehicles.Vehicle;

/**
 * Created by Hedgehog on 04.07.2015.
 */

public class Road {
	
	private LinkedList<Vehicle> r1;
	private float l, sL, sD;
	private ArrayList<Road> c = new ArrayList<Road>();
	private String name; 
	private Export e;
	
	public Road(String Label, float length, float speedLimit, float safetyDistance, Road[] connections){
		name = Label;
		l = length;
		sL = speedLimit;
		sD = safetyDistance;
		
		e = new Export(this.toString());
		e.startWriter();
		
		r1 = new LinkedList<Vehicle>();
		
		for(Road road1 : connections){
			c.add(road1);
		}
	}

	public Road(String Label, float length, float speedLimit, float safetyDistance){
		name = Label;
		l = length;
		sL = speedLimit;
		sD = safetyDistance;
			
		e = new Export(this.toString());
		e.startWriter();
		
		r1 = new LinkedList<Vehicle>();
	}
	
	public void updateAll(float i){
		for(int j = r1.size()-1; j >=0; j--){
			Vehicle v1 = r1.get(j);
			if(r1.getFirst() == v1){
				handleFirst(v1, i);
			}
			else v1.updateVelocity(r1.get(j-1),i);	
		}
		print();
	}
	
	private void print() {
		if(r1.size() !=0){
			String p = "";
			for(Vehicle v1 : r1){
				p = p + v1.toString() + "; ";
			}
			e.save(p);
			e.newLine();
		}
		else e.resetPre();
	}

	private void handleFirst(Vehicle v, float i){
		if(v.getPosition() >= l){
			if(c.size() != 0){
				v.stop();
				Random r = new Random();
				int j = r.nextInt(c.size());
				if(c.get(j).addVehicle(v)){
					v.setPosition(0);
					r1.remove(v);
					e.addPre();
				}
			}
			else{
				r1.remove(v);
				e.addPre();
			}
		}
		else v.updateVelocity(i);
	}
	
	public boolean addVehicle(Vehicle v){
		if(noSpace(v)){
			return false;
		}
		r1.add(v);
		return true;
	}
	
	private boolean noSpace(Vehicle v){
		if(r1.size() == 0) return false;
		if((r1.getLast().getPosition() - r1.getFirst().getLength()) < v.getLength()) return true;
		return false;
	}
	
	public boolean contains(Vehicle v) {
		return r1.contains(v);
	}
	
	public float getLength(){
		return l;
	}
	
	public float getSpeedLimit(){
		return sL;
	}
	
	public float getSafetyDistance(){
		return sD;
	}
	
	@Override
	public String toString(){
		return name;
	}
	
	public void stop(){
		e.stopWriter();
	}

	public void addConnection(Road con) {
		c.add(con);
	}

	public String getLabel() {
		return name;
	}
	
}
