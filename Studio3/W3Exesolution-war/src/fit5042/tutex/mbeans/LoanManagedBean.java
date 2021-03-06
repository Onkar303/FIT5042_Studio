/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.mbeans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fit5042.tutex.repository.entities.Loan;
import fit5042.tutex.calculator.MonthlyPaymentCalculator;

/**
 *
 * @author: originally created by Eddie. The following code has been changed in
 * order for students to practice.
 */
@ManagedBean(name = "loanManagedBean",eager = true)
@SessionScoped
public class LoanManagedBean implements Serializable {

	@EJB
	MonthlyPaymentCalculator monthlyPaymentCalculator;
	
	private Loan loan;

    public LoanManagedBean() {
        this.loan = new Loan();

    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public String calculate() {
        
        double monthlyPayment = 0;
        
        loan.setMonthlyPayment(monthlyPayment);
        
       
        //You will need to modify the monthlyPayment value and set it as the monthly payment attribute value into the loan instance
        //Please complete this method starts from here
        
        loan.setMonthlyPayment(monthlyPaymentCalculator.calculate(loan.getPrinciple(), loan.getNumberOfYears(), loan.getInterestRate()));

        return "index";
    }
}
