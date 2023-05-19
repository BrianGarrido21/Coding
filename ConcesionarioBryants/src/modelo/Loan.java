package modelo;

public class Loan {
    private double totalAmount;
    private int years;
    private double interestRate;
    
    public Loan(int totalAmount, int years, double interestRate) {
        this.totalAmount = totalAmount;
        this.years = years;
        this.interestRate = interestRate;
    }
    
    public double getPaymentAmount() {
        double interestPerMonth = (interestRate / 100) / 12;
        int totalMonths = years * 12;
        double paymentPerMonth = (totalAmount * (1 - 0.25)) 
        		* ((interestPerMonth * Math.pow(1 + interestPerMonth, totalMonths)) 
        		/ (Math.pow(1 + interestPerMonth, totalMonths) - 1));
        return Math.round(paymentPerMonth*1000)/1000;
    }
    
    
    public int getFirstPayment() {
        return (int) (Math.round(totalAmount * 0.25));
    }
    
    public double getTotalInterst() {
    	return Math.round((totalAmount +(totalAmount/interestRate))*1000)/1000;
    }
    
}
