package controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import modelo.Dictionary;
import modelo.HangMan;

public class Handle implements Initializable{
	
    @FXML
    private TextField intro;

    @FXML
    private Label mask;

    @FXML
    private Label vidas;
    
    @FXML
    private ImageView foto;
    
    @FXML
    private Button check;
    
    private Dictionary d;
    
    private HangMan h;
    
	private Image fail0=new Image("Drawing.png");
	private Image fail1=new Image("Drawing-2.png");
	private Image fail2=new Image("Drawing-3.png");
	private Image fail3=new Image("Drawing-4.png");
	private Image fail4=new Image("Drawing-5.png");

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		d=new Dictionary();
		h=new HangMan(d.getRandomWord());
		 mask.setText(h.getMask());
		 
	}
	
    @FXML
    public void manejador(ActionEvent event) {
    
    /**
     * Accion de meter letra.
     */
     char letter= intro.getText().toUpperCase().charAt(0);
     boolean valid=h.checkLetter(letter);
     
     /*
      * Comprueba si esta la letra
      */
     if(valid) 
    	 mask.setText(h.getMask());
     else
     h.upFails();

     
     /*
      * Te pone el numero en la label.
      */
     String fails=Integer.toString(h.getFails());
     vidas.setText(fails);
     intro.clear();
     
     
     /*
      * Termina el juego si completas la palabra.
      */
     boolean youWin=h.youWin();
     if(youWin) {
    	 intro.setDisable(true);
    	 mask.setText("You win 👍");
     }
     
    }
    
   
}
	