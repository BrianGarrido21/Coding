package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import model.Loan;
import viewLoan.MainPanel;

public class LoanController {
	
	private MainPanel vista;
	private Loan modelo;
	
	private Button boton;
	
	public LoanController(MainPanel vista, Loan modelo) {
		this.vista = vista;
		this.modelo = modelo;
		
		boton = vista.getCalculate();
		
		boton.setOnAction(new Manejador());
		
	}
	class Manejador implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent arg0) {
			// TODO Auto-generated method stub
			double m = Double.parseDouble(vista.getAmount().getText());
			modelo.setLoanAmount(m);
			
			int y = Integer.parseInt(vista.getYears().getText());
			modelo.setNumberOfYears(y);
			
			double i =  Double.parseDouble(vista.getInterest().getText());
			modelo.setAnnualInterestRate(i);
			
			double mp = modelo.getMonthlyPayment();
			String payment = Double.toString(mp);
			
			vista.getMounthly().setText(payment);
		}
		
	}

}

