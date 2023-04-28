package Lesson4.GameImprove;

public class AttackGame {
    public static void main(String[] args) {
    new AttackGame().run();
    }
    public void run() {
        println("Game started");
        int avatar1 = Keyboard.readInt("Player 1 enter 1 for Ranger, 2 for Digger:");
        int avatar2 = Keyboard.readInt("Player 2 enter 1 for Ranger, 2 for Digger:");
        
        AvatarInterface player1 = AvatarFactory.getAvatar(avatar1);
        AvatarInterface player2 = AvatarFactory.getAvatar(avatar2);
        int force1=0,force2=0,power1=0,power2=0;
        for(int round=1;round<=5;round++){
            println("Round:"+round);
            force1 = player1.attack();
            force2 = player2.attack();
            player1.lostPower(force2);
            player2.lostPower(force1);
            power1 = player1.getPower();
            power2 = player2.getPower();
        }

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
    
