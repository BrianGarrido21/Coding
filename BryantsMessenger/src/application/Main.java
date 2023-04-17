package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage PrimaryStage) {
		
		try {	
			Parent root=FXMLLoader.load(getClass().getResource("/vista/logInFinal.fxml"));
//			
//			FXMLLoader loader= new FXMLLoader(getClass().getResource("/vista/logIn.fxml"));
//			Parent root = loader.load();
			Scene scene = new Scene(root,335,600);
			PrimaryStage.setScene(scene);
			PrimaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
