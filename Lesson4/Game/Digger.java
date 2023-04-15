package Lesson4.Game;

import java.util.*;

public class Digger {
    private int power, factor;
    private Random r = new Random();
    public Digger(){
    this.power = r.nextInt(5);
    this.factor = r.nextInt(10);
    }
    public int attack(){
    //Algorithm for attack method in Digger
    int force = factor*r.nextInt(Math.abs(power)+1);
    return force;
    }
    public void lostPower(int p){
    power-=factor*p;
    }
    public int getPower(){
    return power;
    }
    }
