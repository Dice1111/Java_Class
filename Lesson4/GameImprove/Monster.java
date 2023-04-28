package Lesson4.GameImprove;

public class Monster extends Avatar{
    public Monster(){
        this.power = r.nextInt(7);
        this.factor = r.nextInt(12);
    }

    public int attack(){
        //Algorithm for attack method in Digger
        int force = factor*r.nextInt(Math.abs(power)+10);
        return force;
    }
}
