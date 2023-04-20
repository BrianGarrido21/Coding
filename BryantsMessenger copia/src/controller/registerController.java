package controller;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.ConectaSql;
import model.Person;
import javax.swing.JOptionPane;

public class registerController {

    @FXML
    private TextField email;

    @FXML
    private Button goBack;

    @FXML
    private TextField name;

    @FXML
    private TextField pass;

    @FXML
    private Button register;
    
    ConectaSql sql;
    
    Stage stage;
    
    @FXML
    void RController(ActionEvent event) throws SQLException, IOException {
    	sql=new ConectaSql();
    	String n=name.getText();
    	String e=email.getText();
    	String p=pass.getText();
    	Person p1= new Person(n,e,p);
    	boolean add =sql.addUser(p1);
    	email.clear();
    	name.clear();
    	pass.clear();
    	if(add==true) {
    		FXMLLoader loader= new FXMLLoader(getClass().getResource("/vista/logInFinal.fxml"));
        	Parent root = loader.load();
        	Scene scene=new Scene(root);
        	stage=new Stage();
        	stage.setScene(scene);
        	stage.show();
        	Stage myStage= (Stage) this.register.getScene().getWindow();
        	myStage.close();
    	}
    	else
    		JOptionPane.showConfirmDialog(null, "Ha habido un error.\nVuelvelo a intentar");
    	
    	
    	
    }
    
    @FXML
    void bController(ActionEvent event) throws IOException {
    	FXMLLoader loader= new FXMLLoader(getClass().getResource("/vista/logInFinal.fxml"));
    	Parent root = loader.load();
    	Scene scene=new Scene(root);
    	stage=new Stage();
    	stage.setScene(scene);
    	stage.show();
    	Stage myStage= (Stage) this.goBack.getScene().getWindow();
    	myStage.close();
    }

}