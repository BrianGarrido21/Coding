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
import modelo.Creditc;
import modelo.User;

public class registerController {

    @FXML
    private TextField RegisterEmailTField;

    @FXML
    private PasswordField RegisterPassTField;

    @FXML
    private TextField RegisterTelTField;

    @FXML
    private Button rRegisterButton;

    @FXML
    private TextField registerNombreTField;
    
    @FXML
    private Button backButton;
    
    Stage stage;
    
    ConectaSQL sql;
    
    Creditc cr;
    
    User u=new User();
    @FXML
    void RegRegisterEvent(ActionEvent event) throws SQLException, IOException {
    	sql=new ConectaSQL();
    	
    	String email=RegisterEmailTField.getText();
    	String pass=RegisterPassTField.getText();
    	String tel=RegisterTelTField.getText();
    	String name=registerNombreTField.getText();
    	int money=0;
    	u=new User(name,email,tel,pass, money, u.getCreditC());
    	sql.addUser(u); 
    	register();
    	}
    
    void register() throws IOException {
    	FXMLLoader loader= new FXMLLoader(getClass().getResource("/vista/logIn.fxml"));
    	Parent root = loader.load();
    	Scene scene=new Scene(root);
    	stage=new Stage();
    	stage.setScene(scene);
    	stage.show();
    	Stage myStage= (Stage) this.rRegisterButton.getScene().getWindow();
    	myStage.close();
    }
    

    @FXML
    void regBackEvent(ActionEvent event) throws IOException {
    	register();
    }

}