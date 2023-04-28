package Lesson4.GameImprove;

import java.util.Random;

public abstract class Avatar implements AvatarInterface {
    protected int power, factor;
    protected Random r;

    public Avatar(){
        r = new Random();
    }

    public void lostPower(int p){
        power -= factor*p;
    }

    public int getPower(){
        return power;
    }

    @Override
    public int attack(){
        return 0;
    }
}
