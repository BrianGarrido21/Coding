package controller;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.ConectaSQL;
import modelo.User;

public class logInController {

    @FXML
    private Button logInButton;

    @FXML
    private TextField logInEmailTextField;

    @FXML
    private PasswordField logInPassTextField;

    @FXML
    private Button registerButton;
    
    Stage stage;
//    int init=0;
    
    protected User u;
    
    ConectaSQL sql;
    public logInController() {
    }
    
    public logInController(User u) {
    	this.u=u;
    }

   
    public User getUser() {
		return u;
	}

	public void setUser(User u) {
		this.u = u;
	}

	@FXML
    void logInEvent(ActionEvent event) throws SQLException, IOException {
    	sql=new ConectaSQL();
    	String e=logInEmailTextField.getText();
    	String pass=logInPassTextField.getText();
    	u=sql.logIn(e, pass);
    	if (u==null) {
    		register();
    	}
    	else {
    		FXMLLoader loader= new FXMLLoader(getClass().getResource("/vista/main.fxml"));
        	Parent root = loader.load();
        	Scene scene=new Scene(root);
        	stage = new Stage();
        	stage.setScene(scene);
        	stage.show();
        	mainController controller = loader.getController();
        	controller.initialize(u);
        	controller.setCars(0);
        	Stage myStage= (Stage) this.registerButton.getScene().getWindow();
        	myStage.close();
    	}
    }

    @FXML
    void registerEvent(ActionEvent event) throws IOException {
    	register();
    }
    
    void register() throws IOException {
    	FXMLLoader loader= new FXMLLoader(getClass().getResource("/vista/register.fxml"));
    	Parent root = loader.load();
    	Scene scene=new Scene(root);
    	stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    	Stage myStage= (Stage) this.registerButton.getScene().getWindow();
    	myStage.close();
    }

}
