package Lesson4.GameImprove;

public class AvatarFactory {
    
    public static AvatarInterface getAvatar(int choise) {
        AvatarInterface avatar = null;
        switch(choise){
            case 1: avatar = new Ranger(); break;
            case 2: avatar = new Digger(); break;
        } 
        return avatar;
    }
}
