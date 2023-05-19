/*package controller;

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
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelo.Car;
import modelo.ConectaSQL;
import modelo.User;

public class mainController implements Initializable {
	User u;

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
	private Label name;

	@FXML
	private Label name1;

	@FXML
	private Label name2;

	@FXML
	private Pagination pagination;

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
	@FXML
	private Button nPageButton;

	Stage stage;

	private ConectaSQL sql;
	private Label[] brandNames, consumes, doorsn, gears, fuels, potencies, prices;
	private ImageView[] images;
	int init;

	@FXML
	void buyEvent(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/typePay.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		stage = new Stage();
		typePayController controller = loader.getController();
		Car c = new Car(1);
		controller.initialize(u, c);
		stage.setScene(scene);
		stage.show();
		Stage myStage = (Stage) this.buyButton.getScene().getWindow();
		myStage.close();
	}

	@FXML
	void buyEvent1(ActionEvent event) {

	}

	@FXML
	void buyEvent2(ActionEvent event) {

	}

	@FXML
	void nextPage(ActionEvent event) throws FileNotFoundException, SQLException {
		ArrayList<Car> cars = sql.getAllCars();
		if (init + 3 >= cars.size()) {
			init = 0; // Reinicia el contador si se llega al final de la lista de coches
		} else {
			init += 3; // Incrementa el contador para mostrar los siguientes coches
		}
		setCars(init);

	}

	public void setCars(int init) throws SQLException, FileNotFoundException {
		sql = new ConectaSQL();
		initializeLabels();
		ArrayList<Car> cars = sql.getAllCars();
		for (int i = init; i < cars.size(); i += 3) {
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

	private void setLabels(int inicio, ArrayList<Car> cars) throws SQLException, FileNotFoundException {
		for (int i = inicio; i < 3; i++) {
			Car car = cars.get(i);
			int labelIndex = (i % 3);
			brandNames[labelIndex].setText(car.getBrand() + " " + car.getName()+" "+ car.getColor());
			consumes[labelIndex].setText(car.getConsume());
			gears[labelIndex].setText(car.getGear());
			doorsn[labelIndex].setText(car.getDoors());
			fuels[labelIndex].setText(car.getFuel());
			potencies[labelIndex].setText(car.getPotency());
			prices[labelIndex].setText(car.getPrice() + " Euros");
			images[labelIndex].setImage(new Image(new FileInputStream(car.getUrl())));
		
		}
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	public void initialize(User u) {
		this.u = u;
		System.out.println(u);
	}

}
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
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelo.Car;
import modelo.ConectaSQL;
import modelo.User;

public class mainController extends logInController {


    @FXML
    private Pagination pagination;

	@FXML
	private Label BrandBame1;

	@FXML
	private Label brandName3;

	@FXML
	private Label brandname2;

	@FXML
	private Button buyButton1;

	@FXML
	private Button buyButton2;

	@FXML
	private Button buyButton3;

	@FXML
	private Label color1;

	@FXML
	private Label color2;

	@FXML
	private Label color3;

	@FXML
	private Label consume1;

	@FXML
	private Label consume2;

	@FXML
	private Label consume3;

	@FXML
	private Label doors1;

	@FXML
	private Label doors2;

	@FXML
	private Label doors3;

	@FXML
	private Label fuel1;

	@FXML
	private Label fuel2;

	@FXML
	private Label fuel3;

	@FXML
	private ImageView image1;

	@FXML
	private ImageView image2;

	@FXML
	private ImageView image3;

	@FXML
	private Label potency1;

	@FXML
	private Label potency2;

	@FXML
	private Label potency3;

	@FXML
	private Label price1;

	@FXML
	private Label price2;

	@FXML
	private Label price3;

	@FXML
	private Button userButton;

	@FXML
	private Button nextPageButton;

	@FXML
	private Button MainBackButton;

	@FXML
	private Label gear1;

	@FXML
	private Label gear2;

	@FXML
	private Label gear3;

	Stage stage;
	Car c;

	@FXML
	void MainGoBackEvent(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/logIn.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		stage = new Stage();
		stage.setScene(scene);
		stage.show();
		Stage myStage = (Stage) this.MainBackButton.getScene().getWindow();
		myStage.close();
	}

	@FXML
	void MainNPageEvent(ActionEvent event) throws IOException, SQLException {
		ArrayList<Car> cars = sql.getAllCars();
		for (int i = 0; i < cars.size(); i += 3) {
			setLabels(i, cars);
		}
	}

	@FXML
	void UserMainButtonEvent(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/usermain.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		stage = new Stage();
		stage.setScene(scene);
		stage.show();
		Stage myStage = (Stage) this.userButton.getScene().getWindow();
		myStage.close();

	}



	@FXML
	void buyEvent1(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/typePay.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		stage = new Stage();
		stage.setScene(scene);
		stage.show();
		Stage myStage = (Stage) this.buyButton1.getScene().getWindow();
		myStage.close();
	}

	@FXML
	void buyEvent2(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/typePay.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		stage = new Stage();
		stage.setScene(scene);
		stage.show();
		Stage myStage = (Stage) this.buyButton2.getScene().getWindow();
		myStage.close();
	}

	@FXML
	void buyEvent3(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/typePay.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		stage = new Stage();
		stage.setScene(scene);
		stage.show();
		Stage myStage = (Stage) this.buyButton3.getScene().getWindow();
		myStage.close();
	}

}
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
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelo.Car;
import modelo.ConectaSQL;
import modelo.User;

public class mainController implements Initializable {
    User u;
    private ConectaSQL sql;
    private int carsPerPage = 3;
    private ArrayList<Car> cars;
    private int currentPageIndex = 0;

    @FXML
    private Pagination pagination;

    

    @FXML
    void nextPage(ActionEvent event) throws FileNotFoundException, SQLException {
        currentPageIndex++;
        updatePage(currentPageIndex);
    }

    @FXML
    void previousPage(ActionEvent event) throws FileNotFoundException, SQLException {
        if (currentPageIndex > 0) {
            currentPageIndex--;
        }
        updatePage(currentPageIndex);
    }

    private void updatePage(int pageIndex) throws FileNotFoundException, SQLException {
        int fromIndex = pageIndex * carsPerPage;
        int toIndex = Math.min(fromIndex + carsPerPage, cars.size());

        setCars(cars.subList(fromIndex, toIndex));
    }

    public void setCars(List<Car> carsOnPage) throws SQLException, FileNotFoundException {
        for (int i = 0; i < carsOnPage.size(); i++) {
            Car car = carsOnPage.get(i);
            brandNames[i].setText(car.getBrand() + " " + car.getName() + " " + car.getColor());
            consumes[i].setText(car.getConsume());
            gears[i].setText(car.getGear());
            doorsn[i].setText(car.getDoors());
            fuels[i].setText(car.getFuel());
            potencies[i].setText(car.getPotency());
            prices[i].setText(car.getPrice() + " Euros");
            images[i].setImage(new Image(new FileInputStream(car.getUrl())));
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        sql = new ConectaSQL();
        initializeLabels();
        try {
            cars = sql.getAllCars();
            updatePage(0); // Muestra la primera página de coches cuando la aplicación se inicia
        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    
}
private void setLabels(int inicio, ArrayList<Car> cars) throws SQLException, FileNotFoundException {
    for (int i = 0; i < 3; i++) {
        if (inicio + i >= cars.size()) {
            // Cuando no hay más coches para mostrar, limpia los Labels restantes
            brandNames[i].setText("");
            consumes[i].setText("");
            gears[i].setText("");
            doorsn[i].setText("");
            fuels[i].setText("");
            potencies[i].setText("");
            prices[i].setText("");
            images[i].setImage(null);
        } else {
            Car car = cars.get(inicio + i);
            brandNames[i].setText(car.getBrand() + " " + car.getName()+" "+ car.getColor());
            consumes[i].setText(car.getConsume());
            gears[i].setText(car.getGear());
            doorsn[i].setText(car.getDoors());
            fuels[i].setText(car.getFuel());
            potencies[i].setText(car.getPotency());
            prices[i].setText(car.getPrice() + " Euros");
            images[i].setImage(new Image(new FileInputStream(car.getUrl())));
        }
    }
}
private void setLabels(int inicio, ArrayList<Car> cars) throws SQLException, FileNotFoundException {
    for (int i = 0; i < 3; i++) {
        if (inicio + i >= cars.size()) {
            break;
        }
        Car car = cars.get(inicio + i);
        brandNames[i].setText(car.getBrand() + " " + car.getName()+" "+ car.getColor());
        consumes[i].setText(car.getConsume());
        gears[i].setText(car.getGear());
        doorsn[i].setText(car.getDoors());
        fuels[i].setText(car.getFuel());
        potencies[i].setText(car.getPotency());
        prices[i].setText(car.getPrice() + " Euros");
        images[i].setImage(new Image(new FileInputStream(car.getUrl())));
    }
}
@FXML
void nextPage(ActionEvent event) throws FileNotFoundException, SQLException {
    ArrayList<Car> cars = sql.getAllCars();
    if (init + 3 >= cars.size()) {
        init = 0; // Reinicia el contador si se llega al final de la lista de coches
    } else {
        init += 3; // Incrementa el contador para mostrar los siguientes coches
    }
    setCars(init); // Actualiza los Labels con los nuevos coches
}
*/
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
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelo.Car;
import modelo.ConectaSQL;
import modelo.User;

public class mainController implements Initializable {
	User u;

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
	private Label name;

	@FXML
	private Label name1;

	@FXML
	private Label name2;

	@FXML
	private Pagination pagination;

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
	@FXML
	private Button nPageButton;

	Stage stage;

	private ConectaSQL sql;
	private Label[] brandNames, consumes, doorsn, gears, fuels, potencies, prices;
	private ImageView[] images;
	int init;

	@FXML
	void buyEvent(ActionEvent event) throws IOException, SQLException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/typePay.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		stage = new Stage();
		typePayController controller = loader.getController();
		Car c = sql.getCar(1);
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
		Car c = sql.getCar(2);
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
		Car c = sql.getCar(3);
		controller.initialize(u, c);
		stage.setScene(scene);
		stage.show();
		Stage myStage = (Stage) this.buyButton.getScene().getWindow();
		myStage.close();
	}

	@FXML
	void nextPage(ActionEvent event) throws SQLException, IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/main2.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		stage = new Stage();
		main2Controller controller = loader.getController();
		controller.initialize(u);
		controller.setCars(3);
		stage.setScene(scene);
		stage.show();
		Stage myStage = (Stage) this.buyButton.getScene().getWindow();
		myStage.close();
	}

	public void setCars(int init) throws SQLException, FileNotFoundException {
		sql = new ConectaSQL();
		ArrayList<Car> cars = sql.getAllCars();
		for (int i = init; i < cars.size(); i += 3) {
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

	private void setLabels(int inicio, ArrayList<Car> cars) throws SQLException, FileNotFoundException {
		for (int i = 0; i < 3; i++) {
			Car car = cars.get(i);
			brandNames[i].setText(car.getBrand() + " " + car.getName() + " " + car.getColor());
			consumes[i].setText(car.getConsume());
			gears[i].setText(car.getGear());
			doorsn[i].setText(car.getDoors());
			fuels[i].setText(car.getFuel());
			potencies[i].setText(car.getPotency());
			prices[i].setText(car.getPrice() + " Euros");
			images[i].setImage(new Image(new FileInputStream(car.getUrl())));
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {
			sql = new ConectaSQL();
			initializeLabels();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void initialize(User u) {
		this.u = u;
		System.out.println(u);
	}

}
