package Lesson4.GameImprove;
import java.util.*;
public class Ranger extends Avatar {

    public Ranger(){
    this.power = r.nextInt(10);
    this.factor = r.nextInt(5);
    }

    public int attack(){
    //Algorithm for attack method in Ranger
    int rNum = r.nextInt(1);
    int force = factor*r.nextInt(Math.abs(power)+1);
    if(rNum%2==0){
    force += r.nextInt(Math.abs(power/(factor+1)+1));
    }else{ 
    force -= r.nextInt(Math.abs(power/(factor+1)+1));
    }
    return force;
    }
}
