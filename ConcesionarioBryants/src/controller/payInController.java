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

public class payInController implements Initializable{

    @FXML
    private Button gobackbutton;
    @FXML
    private Button payInButton;

    @FXML
    private TextField payInCreditCTField;

    @FXML
    private TextField payInEmailTField;

    @FXML
    private TextField payInMoneyTField;

    @FXML
    private Label payInName;

    ConectaSQL sql;
    User u;
    
    @FXML
    void payInEvent(ActionEvent event) throws SQLException {
    	
    	String cc=payInCreditCTField.getText();
    	int c=Integer.parseInt(payInMoneyTField.getText());
    	sql.addMoney(u, c, cc );
    	u= sql.getUser(u.getEmail());
    }

    @FXML
    void payInGoBack(ActionEvent event) throws IOException {
    	FXMLLoader loader= new FXMLLoader(getClass().getResource("/vista/usermain.fxml"));
    	Parent root = loader.load();
    	Scene scene=new Scene(root);
    	Stage stage = new Stage();
    	userMainController controller = loader.getController();
    	controller.initialize(u);
    	stage.setScene(scene);
    	stage.show();
    	Stage myStage= (Stage) this.gobackbutton.getScene().getWindow();
    	myStage.close();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {
			sql=new ConectaSQL();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initialize(User u) {
		this.u=u;
		System.out.println(u);
	}

}
