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
import model.ConectaSql;
import model.Person;

public class logInHandle {

    @FXML
    private TextField email;

    @FXML
    private Button logIn;

    @FXML
    private PasswordField pass;

    @FXML
    private Button register;
    
    ConectaSql sql;
    
    Stage stage = new Stage();
    
    private Person person;
    
  

	public void setPerson(Person person) {
		this.person = person;
	}
	
	

	@FXML
    void logInControl(ActionEvent event) throws SQLException, IOException {
    	sql= new ConectaSql();
    	String e= email.getText();
    	String p=pass.getText();
    	this.person =sql.getUser(e, p);
    	//this.person= new Person(e,p);
    	if(person==null)
    		register();
    	else {
    		FXMLLoader loader= new FXMLLoader(getClass().getResource("/vista/userListFinal.fxml"));
        	Parent root = loader.load();
        	Scene scene=new Scene(root);
        	stage=new Stage();
        	stage.setScene(scene);
        	stage.show();
        	Stage myStage= (Stage) this.logIn.getScene().getWindow();
        	myStage.close();
    	}
   
    }

    @FXML
    void registerControl(ActionEvent event) throws IOException {
    	
    	register();
    	
    }


    void register() throws IOException{
    	FXMLLoader loader= new FXMLLoader(getClass().getResource("/vista/registerFinal.fxml"));
    	Parent root = loader.load();
    	Scene scene=new Scene(root);
    	stage=new Stage();
    	stage.setScene(scene);
    	stage.show();
    	Stage myStage= (Stage) this.register.getScene().getWindow();
    	myStage.close();
    }
}