package viewLoan;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class MainPanel extends GridPane{
	
	private Label amountLabel;
	private Label interestLabel;
	private Label yearsLabel;
	
	private Label mounthlyLabel;
	private Label totalLabel;
	
	
	private TextField amount;
	private TextField interest;
	private TextField years;
	
	private TextField mounthly;
	private TextField total;
	
	private Button calculate;
	
	public MainPanel() {
		this.setVgap(20);
		this.setHgap(20);
		
		this.setAlignment(Pos.BASELINE_CENTER);
		
		this.amountLabel = new Label("Total Amount:");
		this.interestLabel =new Label("Interest rate:");
		this.yearsLabel = new Label("number of years:");
		
		this.mounthlyLabel = new Label("MounthLy Payment:");
		this.totalLabel = new Label("Total Payment:");
		
		this.amount = new TextField();
		this.interest = new TextField();
		this.years = new TextField();
		
		this.mounthly = new TextField();
		this.total = new TextField();
		calculate = new Button ("Calculator");
		
		this.add(this.amountLabel,0, 0 );
		this.add( this.amount,1, 0);
		this.add(this.interestLabel, 0, 1);
		
	
		
		
		this.add(this.interest,1,1);
		
		this.add(this.yearsLabel, 0, 2);
		this.add(this.years,1,2);
		this.add(this.mounthlyLabel, 0, 3);
		this.add(this.mounthly, 1, 3);
		
		this.add(this.totalLabel, 0, 4);
		
		
		
		this.add(this.total, 1, 4);
		
		this.add(this.calculate, 1, 5);
		
		
		
		
	}

	public Label getTotalLabel() {
		return totalLabel;
	}

	public void setTotalLabel(Label totalLabel) {
		this.totalLabel = totalLabel;
	}

	public TextField getMounthly() {
		return mounthly;
	}

	public void setMounthly(TextField mounthly) {
		this.mounthly = mounthly;
	}

	public TextField getTotal() {
		return total;
	}

	public void setTotal(TextField total) {
		this.total = total;
	}

	public TextField getAmount() {
		return amount;
	}

	public TextField getInterest() {
		return interest;
	}

	public TextField getYears() {
		return years;
	}

	public Button getCalculate() {
		return calculate;
	}

}
