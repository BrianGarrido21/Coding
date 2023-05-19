//package controller;
//
//import java.net.URL;
//import java.sql.SQLException;
//import java.util.ResourceBundle;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import modelo.Car;
//import modelo.ConectaSQL;
//import modelo.Invoice;
//import modelo.Loan;
//import modelo.User;
//
//public class totalController  {
//
//	@FXML
//	private Button paybutton;
//
//	@FXML
//	private Label total;
//
//	@FXML
//	private Label wallet;
//

//
//	@FXML
//	void totalEvent(ActionEvent event) throws SQLException {

//	}
//

//
//	@Override
//	public void initialize(URL arg0, ResourceBundle arg1) {
//		// TODO Auto-generated method stub
//
//	}
//
	
//}

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
import javafx.stage.Stage;
import modelo.Car;
import modelo.ConectaSQL;
import modelo.User;

public class totalController implements Initializable {

    @FXML
    private Button goBack;

    @FXML
    private Button paybutton;

    @FXML
    private Label total;

    @FXML
    private Label wallet;
	Car c;
	User u;
	ConectaSQL sql;
	Stage stage;

    @FXML
    void goBackEvent(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/typePay.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		stage = new Stage();
		typePayController controller = loader.getController();
		controller.initialize(u, c);
		stage.setScene(scene);
		stage.show();
		Stage myStage = (Stage) this.goBack.getScene().getWindow();
		myStage.close();
    }
    

    @FXML
    void totalEvent(ActionEvent event) throws SQLException {
		sql.buyTotal(u, c);
    }
    
	public void setItems() {
		total.setText(c.getPrice() + " euros");
		wallet.setText(u.getMoney() + " euros");
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
	public void initialize(User u, Car c) {
		this.c=c;
		this.u=u;
		System.out.println(c+"\n"+u);
	}

}
