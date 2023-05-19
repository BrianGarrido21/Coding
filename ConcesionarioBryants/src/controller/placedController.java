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
import modelo.Car;
import modelo.ConectaSQL;
import modelo.Loan;
import modelo.User;


public class placedController implements Initializable{

    @FXML
    private TextField YearsTfField;

    @FXML
    private Label firstPay;

    @FXML
    private Label interest;

    @FXML
    private Label paymes;
    

    @FXML
    private Button placedButton;

    @FXML
    private Label quantity;

    @FXML
    private Label total;

    @FXML
    private Label wallet;
    
    @FXML
    private Button actualizarButton;
    @FXML
    private Button goback;
    Stage stage;
    Car c;
    User u;
    Loan l;
    ConectaSQL sql;
    
    @FXML
    void goback(ActionEvent event) throws IOException, SQLException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/typePay.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		stage = new Stage();
		typePayController controller = loader.getController();
		controller.initialize(u, c);
		stage.setScene(scene);
		stage.show();
		Stage myStage = (Stage) this.goback.getScene().getWindow();
		myStage.close();
    }
    

    @FXML
    void PlacedEvent(ActionEvent event) throws SQLException {
    	
    	sql.buyPlaced(u,c,l);
    	
    }

    @FXML
    void actualizar(ActionEvent event) {
    	String y=YearsTfField.getText();
    	setItems(y);
    }
    
    public void setItems() {
    	int years= 0;
    	l= new Loan(c.getPrice(),years,5);
    	total.setText(l.getPaymentAmount()+" euros");
    	quantity.setText(c.getPrice()+ " euros");
    	firstPay.setText(l.getFirstPayment()+" euros");
    	paymes.setText(l.getPaymentAmount()+ " euros");
    	total.setText(l.getTotalInterst()+" euros");
    	interest.setText(3 +"%");
    	wallet.setText(u.getMoney()+" euros");
    }
    public void setItems(String y) {
    	int years= Integer.parseInt(y);
    	l= new Loan(c.getPrice(),years,5);
    	total.setText(l.getPaymentAmount()+" euros");
    	firstPay.setText(l.getFirstPayment()+" euros");
    	quantity.setText(c.getPrice()+ " euros");
    	paymes.setText(l.getPaymentAmount()+ " euros");
    	total.setText(l.getTotalInterst()+" euros");
    	interest.setText(3 +"%");
    	wallet.setText(u.getMoney()+" euros");
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
	public void initialize(User u,Car c) {
		this.u=u;
		this.c=c;
		System.out.println(u+"\n"+c);
	}

}
