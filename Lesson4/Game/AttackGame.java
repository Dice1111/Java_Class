package Lesson4.Game;

public class AttackGame {
    public static void main(String[] args) {
    new AttackGame().run();
    }
    public void run() {
    //Player choose avatar
    println("Game started");
    int avatar1 = Keyboard.readInt("Player 1 enter 1 for Ranger, 2 for Digger:");
    int avatar2 = Keyboard.readInt("Player 2 enter 1 for Ranger, 2 for Digger:");
     //Game engine
    int force1=0,force2=0,power1=0,power2=0;
    if (avatar1 == 1 && avatar2 == 1) {
    Ranger player1 = new Ranger(); Ranger player2 = new Ranger();
    for(int round=1;round<=5;round++){
    println("Round:"+round);
    force1 = player1.attack();
    force2 = player2.attack();
    player1.lostPower(force2);
    player2.lostPower(force1);
    power1 = player1.getPower();
    power2 = player2.getPower();
    }
    } else if (avatar1 == 1 && avatar2 == 2) {
    Ranger player1 = new Ranger(); Digger player2 = new Digger();
    for(int round=1;round<=5;round++){
    println("Round:"+round);
    force1 = player1.attack();
    force2 = player2.attack();
    player1.lostPower(force2);
    player2.lostPower(force1);
    power1 = player1.getPower();
    power2 = player2.getPower();
    }
    } else if (avatar1 == 2 && avatar2 == 1) {
    Digger player1 = new Digger(); Ranger player2 = new Ranger();
    for(int round=1;round<=5;round++){
    println("Round:"+round);
    force1 = player1.attack();
    force2 = player2.attack();
    player1.lostPower(force2);
    player2.lostPower(force1);
    power1 = player1.getPower();
    power2 = player2.getPower();
    }
    }else if (avatar1 == 2 && avatar2 == 2) {
    Digger player1 = new Digger(); Digger player2 = new Digger();
    for(int round=1;round<=5;round++){
    println("Round:"+round);
    force1 = player1.attack();
    force2 = player2.attack();
    player1.lostPower(force2);
    player2.lostPower(force1);
    power1 = player1.getPower();
    power2 = player2.getPower();
    }
    }
    //Determine Winner
    if(power1>power2){
    println("Player 1 wins!");
    }else if(power1<power2){
    println("Player 2 wins!");
    }else{
    println("It is a tie!");
    }
    }
    public static void println(String s) {
    System.out.println(s);
    }
    }
    
