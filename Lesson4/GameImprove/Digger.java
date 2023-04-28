package Lesson4.GameImprove;

import java.util.*;

public class Digger extends Avatar {

    public Digger(){
    this.power = r.nextInt(5);
    this.factor = r.nextInt(10);
    }
    public int attack(){
    //Algorithm for attack method in Digger
    int force = factor*r.nextInt(Math.abs(power)+1);
    return force;
    }

}
