import Model.*;
import Controller.*;
import View.*;

public class HighSum {

	private Dealer dealer;
	private Player player;
	private ViewController view;
    private GameController gc;
    
    public HighSum() {
    	//create all the required objects
    	this.dealer = new Dealer();
        this.player = new Player("IcePeak","password",100);
        this.view = new ViewController(this.dealer,this.player);
        //bring them together
    	this.gc = new GameController(this.dealer,this.player,this.view);
    }
	
    public void run() {
    	//starts the game!
    	gc.run();
    }
    
	public static void main(String[] args) {
	    new HighSum().run();
	}

}
