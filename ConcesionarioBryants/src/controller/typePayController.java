package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import modelo.Car;
import modelo.User;

public class typePayController implements Initializable {

    @FXML
    private Button fullButton;

    @FXML
    private Button goBack;

    @FXML
    private Button placedButton;
    
    Stage stage;
    User u;
    Car c;
    @FXML
    void typePayGobackEvent(ActionEvent event) throws IOException, SQLException {
    	FXMLLoader loader= new FXMLLoader(getClass().getResource("/vista/main.fxml"));
    	Parent root = loader.load();
    	Scene scene=new Scene(root);
    	mainController controller = loader.getController();
    	controller.initialize(u);
    	controller.setCars(0);
    	stage=new Stage();
    	stage.setScene(scene);
    	stage.show();
    	Stage myStage= (Stage) this.goBack.getScene().getWindow();
    	myStage.close();
    }

    @FXML
    void typePayPlacedEvent(ActionEvent event) throws IOException {
    	FXMLLoader loader= new FXMLLoader(getClass().getResource("/vista/placed.fxml"));
    	Parent root = loader.load();
    	Scene scene=new Scene(root);
    	stage=new Stage();
    	placedController controller = loader.getController();
    	controller.initialize(u,c);
    	controller.setItems();
    	stage.setScene(scene);
    	stage.show();
    	Stage myStage= (Stage) this.placedButton.getScene().getWindow();
    	myStage.close();
    	
    }

    @FXML
    void typePayfullEvent(ActionEvent event) throws IOException {
    	FXMLLoader loader= new FXMLLoader(getClass().getResource("/vista/payOne.fxml"));
    	Parent root = loader.load();
    	Scene scene=new Scene(root);
    	totalController controller = loader.getController();
    	controller.initialize(u,c);
    	controller.setItems();
    	stage=new Stage();
    	stage.setScene(scene);
    	stage.show();
    	Stage myStage= (Stage) this.fullButton.getScene().getWindow();
    	myStage.close();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void initialize(User u,Car c) {
		this.u=u;
		this.c=c;
		System.out.println(u+"\n"+c);
	}

}
