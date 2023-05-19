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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.ConectaSQL;
import modelo.User;

public class userMainController implements Initializable {

    @FXML
    private Button Goback;
    
    @FXML
    private Button userMain;

    @FXML
    private Label userMainEmail;

    @FXML
    private Label userMainName;

    @FXML
    private Label userMainPass;

    @FXML
    private TextField userMainPassTField;

    @FXML
    private Button userMainPayInButton;

    @FXML
    private Label userMainTel;

    @FXML
    private Label userMainTell;
    
    ConectaSQL sql;
    User u;
    Stage stage;
   
    
   
    
    @FXML
    void changeEvent(ActionEvent event) throws SQLException {
    	sql=new ConectaSQL();
    	String newPass=userMainPassTField.getText();
    	sql.change(u, newPass);
    	u=sql.getUser(u.getEmail());
    	setUser(u);
    }
    
    public void setUser(User u) {
    	userMainName.setText(u.getName());
    	userMainEmail.setText(u.getEmail());
    	userMainPass.setText(u.getPassword());
    	userMainTel.setText(u.getTel());
    	userMainTell.setText(u.getMoney()+ " euros");
    	
    }
    
    @FXML
    void payInEvent(ActionEvent event) throws IOException {
    	FXMLLoader loader= new FXMLLoader(getClass().getResource("/vista/payIn.fxml"));
    	Parent root = loader.load();
    	Scene scene=new Scene(root);
    	stage=new Stage();
    	payInController controller = loader.getController();
    	controller.initialize(u);
    	stage.setScene(scene);
    	stage.show();
    	Stage myStage= (Stage) this.userMainPayInButton.getScene().getWindow();
    	myStage.close();
    }

    @FXML
    void userMainGoBackEvent(ActionEvent event) throws IOException, SQLException {
    	FXMLLoader loader= new FXMLLoader(getClass().getResource("/vista/main.fxml"));
    	Parent root = loader.load();
    	Scene scene=new Scene(root);
    	stage=new Stage();
    	stage.setScene(scene);
    	stage.show();
    	mainController controller = loader.getController();
    	controller.initialize(u);
    	controller.setCars(0);
    	Stage myStage= (Stage) this.Goback.getScene().getWindow();
    	myStage.close();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	public void initialize(User u) {
		this.u=u;
		setUser(u);
		System.out.println(u);
		
	}
}
