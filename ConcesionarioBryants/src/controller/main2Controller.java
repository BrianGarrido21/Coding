package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelo.Car;
import modelo.ConectaSQL;
import modelo.User;

public class main2Controller implements Initializable {

    @FXML
    private Button buyButton;

    @FXML
    private Button buyButton1;

    @FXML
    private Button buyButton2;

    @FXML
    private Label consume;

    @FXML
    private Label consume1;

    @FXML
    private Label consume2;

    @FXML
    private Label doors;

    @FXML
    private Label doors1;

    @FXML
    private Label doors2;

    @FXML
    private Label fuel;

    @FXML
    private Label fuel1;

    @FXML
    private Label fuel2;

    @FXML
    private Label gear;

    @FXML
    private Label gear1;

    @FXML
    private Label gear2;

    @FXML
    private Button nPageButton1;

    @FXML
    private Label name;

    @FXML
    private Label name1;

    @FXML
    private Label name2;

    @FXML
    private Label potency;

    @FXML
    private Label potency1;

    @FXML
    private Label potency2;

    @FXML
    private Label price;

    @FXML
    private Label price1;

    @FXML
    private Label price2;

    @FXML
    private ImageView url;

    @FXML
    private ImageView url1;

    @FXML
    private ImageView url2;

    @FXML
    private Button userMain;

    ConectaSQL sql;
    User u;
    Stage stage;
    private Label[] brandNames, consumes, doorsn, gears, fuels, potencies, prices;
	private ImageView[] images;
	int init;

    @FXML
    void Main(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/usermain.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		userMainController controller = loader.getController();
		controller.initialize(u);
		stage.setScene(scene);
		stage.show();
		Stage myStage = (Stage) this.userMain.getScene().getWindow();
		myStage.close();
    }

    @FXML
    void buyEvent(ActionEvent event) throws IOException, SQLException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/typePay.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		stage = new Stage();
		typePayController controller = loader.getController();
		Car c = sql.getCar(4);
		controller.initialize(u, c);
		stage.setScene(scene);
		stage.show();
		Stage myStage = (Stage) this.buyButton.getScene().getWindow();
		myStage.close();
    }

    @FXML
    void buyEvent1(ActionEvent event) throws IOException, SQLException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/typePay.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		stage = new Stage();
		typePayController controller = loader.getController();
		Car c = sql.getCar(5);
		controller.initialize(u, c);
		stage.setScene(scene);
		stage.show();
		Stage myStage = (Stage) this.buyButton.getScene().getWindow();
		myStage.close();
    }

    @FXML
    void buyEvent2(ActionEvent event) throws IOException, SQLException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/typePay.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		stage = new Stage();
		typePayController controller = loader.getController();
		Car c = sql.getCar(6);
		controller.initialize(u, c);
		stage.setScene(scene);
		stage.show();
		Stage myStage = (Stage) this.buyButton.getScene().getWindow();
		myStage.close();
    }

    @FXML
    void previewPage(ActionEvent event) throws IOException, SQLException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/main.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		stage = new Stage();
		mainController controller = loader.getController();
		controller.initialize(u);
		controller.setCars(0);
		stage.setScene(scene);
		stage.show();
		Stage myStage = (Stage) this.buyButton.getScene().getWindow();
		myStage.close();
    }

	public void setCars(int init) throws SQLException, FileNotFoundException {
		ArrayList<Car> cars = sql.getAllCars();
		for (int i = 0; i < cars.size(); i += 3) {
			setLabels(i, cars);
		}
	}

	private void initializeLabels() {
		brandNames = new Label[] { name, name1, name2 };
		consumes = new Label[] { consume, consume1, consume2 };
		gears = new Label[] { gear, gear1, gear2 };
		doorsn = new Label[] { doors, doors1, doors2 };
		fuels = new Label[] { fuel, fuel1, fuel2 };
		potencies = new Label[] { potency, potency1, potency2 };
		prices = new Label[] { price, price1, price2 };
		images = new ImageView[] { url, url1, url2 };
	}
	
	private void setLabels(int inicio, ArrayList<Car> cars) throws SQLException, FileNotFoundException {
	    for (int i = 2; i < 6; i++) {
	            Car car = cars.get(i);
	            int index=(i%3);
	            brandNames[index].setText(car.getBrand() + " " + car.getName()+" "+ car.getColor());
	            consumes[index].setText(car.getConsume());
	            gears[index].setText(car.getGear());
	            doorsn[index].setText(car.getDoors());
	            fuels[index].setText(car.getFuel());
	            potencies[index].setText(car.getPotency());
	            prices[index].setText(car.getPrice() + " Euros");
	            images[index].setImage(new Image(new FileInputStream(car.getUrl())));
	        }
	    }
    public void initialize(User u) {
		this.u = u;
		System.out.println(u);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {
			sql=new ConectaSQL();
			initializeLabels();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
