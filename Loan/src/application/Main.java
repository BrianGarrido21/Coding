package application;
	
import controller.LoanController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Loan;
import viewLoan.MainPanel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			MainPanel loanPanel = new MainPanel();
			StackPane root = new StackPane();
			root.getChildren().add(loanPanel);
			
			Loan loan = new Loan();
			LoanController loanController = new LoanController(loanPanel,loan);
			
			Scene scene = new Scene(root,500,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Loan Calculator");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
