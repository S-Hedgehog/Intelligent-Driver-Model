package com.hedgehog.vehicles;

/**
 * Created by Hedgehog on 04.07.2015.
 */

public class Truck extends Vehicle{

	public Truck(float velocity, float acceleration, float deceleration, float reactionTime, float startingPosition){
		super(velocity, acceleration, deceleration, reactionTime, startingPosition);
		setLength(10);
	}
	
	public Truck(){
		super(0, 1, 3, 2, 0);
		setLength(10);
	}
	
	
}
