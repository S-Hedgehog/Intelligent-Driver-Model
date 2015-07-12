package com.hedgehog.vehicles;

import com.hedgehog.Solver;

/**
 * Created by Hedgehog on 04.07.2015.
 */
public abstract class Vehicle {
    private float v, a, b, T, p, length, sP;

    public Vehicle(){
        v = 0;
        a = 2;
        b = 4;
        T = 1;
        p = 0;
        sP = 0;
    }

    public Vehicle(float velocity, float acceleration, float deceleration, float reactionTime, float startingPosition){
        v = velocity;
        a = acceleration;
        b = deceleration;
        T = reactionTime;
        p = startingPosition;
        sP = 0;  
    }

    public float getVelocity(){
        return v;
    }
    
    public float getAcceleration(){
    	return a;
    }
    
    public float getDeceleration(){
    	return b;
    }
    
    public float getReactionTime(){
    	return T;
    }
    
    public float getReactionDistance(){
    	return v*T;
    }
    
    public float getPosition(){
    	return p;
    }
    
    public float getLength(){
    	return length;
    }
    
    public void setLength(float l){
    	length = l;
    }
    
    public float getSpeedPlus(){
    	return sP;
    }
    
    public void setSpeedPlus(float p){
    	sP = p;
    }
    
    public void updateVelocity(Vehicle vNext, float interval){
    	float aTemp =  Solver.derivative(this, vNext);
    	
    	float pTemp = (float) (p + (v + (0.5*aTemp*interval)) * interval);
    	if(pTemp>p) p = pTemp;
    	v = v + interval *aTemp;
    	if(v<=0) v = 0;
    }

	public void updateVelocity(float interval) {
		float aTemp =  Solver.leaderDerivative(this);
    	
    	float pTemp = (float) (p + (v + (0.5*aTemp*interval)) * interval);
    	if(pTemp>p) p = pTemp;
    	v = v + interval *aTemp;
    	if(v<0) v = 0;
	}
	
	@Override
	public String toString(){
		String s = new String(p +"; "+ v);
		return s;
	}

	public void setPosition(float posi) {
		p = posi;	
	}

	public void stop() {
		v = 0;	
	}
}
