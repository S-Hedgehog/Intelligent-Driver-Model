package com.hedgehog.vehicles;

/**
 * Created by Hedgehog on 04.07.2015.
 */

public class Car extends Vehicle {

	public Car(float velocity, float acceleration, float deceleration, float reactionTime, float startingPosition, float speedPlus) {
		super(velocity, acceleration, deceleration, reactionTime, startingPosition);
		setLength(4);
		setSpeedPlus(speedPlus);
	}

	public Car() {
		super();
		setLength(4);
		setSpeedPlus(0);
	}

}
