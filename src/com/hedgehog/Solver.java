package com.hedgehog;

import com.hedgehog.map.Map;
import com.hedgehog.vehicles.Vehicle;

/**
 * Created by Hedgehog on 04.07.2015.
 */

public class Solver {

    public static float derivative(Vehicle vC, Vehicle vNext) {
        float vDot = 0;
        float sStar = 0;
        
        float a = vC.getAcceleration();
        float b = vC.getDeceleration();
        float r = vC.getReactionDistance();
        float v = vC.getVelocity();
        float s0 = Map.getMinDistance(vC);
        float v0 = Map.getSpeedlimit(vC) + vC.getSpeedPlus();
        
        float deltaV = v - (vNext.getVelocity());
        float s = vNext.getPosition() - vNext.getLength() - vC.getPosition();
        
        sStar = (float) (r+((v*deltaV)/(2*Math.sqrt(a+b))));
        if (sStar<0) sStar = 0;
        
        vDot =  (float) (a * (1 - Math.pow((v/v0), 4)) - Math.pow(((s0+sStar)/(s)), 2));
        
        return vDot;
    }
    
    public static float leaderDerivative(Vehicle vC){
    	float vDot = 0;
        float sStar = 0;
        
        float a = vC.getAcceleration();
        float b = vC.getDeceleration();
        float v = vC.getVelocity();
        float v0 = Map.getSpeedlimit(vC) + vC.getSpeedPlus();
        
        float s = Map.findVehicle(vC).getLength() - vC.getPosition();
        
        sStar = (float) (((v*v)/(2*Math.sqrt(a+b))));
        if (sStar<0) sStar = 0;
        
        vDot =  (float) (a * (1 - Math.pow((v/v0), 4)) - Math.pow(((sStar)/(s)), 2));
        
        return vDot;
    }
}
