package project1;

import java.time.*;

public class Librarian extends Employee {
	
	//instance variables
	private EarnedDegree degree;
	private double yearlyPay;
	
	
	public Librarian (String f, String l, Address addr,  String birthdate,  String hireDate, EarnedDegree degree, double yearlyPay) {
		super(f, l, addr, birthdate, hireDate,30.0);
		this.degree=degree;
		this.yearlyPay=yearlyPay;
	}


	public EarnedDegree  getDegree() {
		return this.degree;
	}
	
	//overloads the Employee.getTotalPay
	public double getTotalPay() {
		int month =LocalDate.now().getMonthValue();
		return (yearlyPay/12 * month); 
	}
	
	@Override //overrides Employee getTotalPay
	public double getTotalPay(int year) {
		return (yearlyPay/12)* (LocalDate.now().getMonthValue()-1); //current month - 1 will give you how many months have been completed/passed
	}
	
	@Override
	public void modifyPay(double pay) {
		this.yearlyPay=pay;
	}
	
	//librarian does not have time sheets so these are empty
	@Override
	public void completeTimeSheet(LocalDate date,double hours)  {;}
	
	@Override
	public void completeTimeSheet(double hours)  {;}

	public int getTotalHoursWorked() {
		int weeksThisMonth =LocalDate.now().getDayOfMonth()/7;
		int monthsPassed =LocalDate.now().getMonthValue()-1;
		return 8*(monthsPassed*4 + weeksThisMonth)-(this.getUsedVacationDays()+this.getUsedSickDays());
	}
	
	public double getPayForWeek (LocalDate x) {
		return yearlyPay /52;
	}

}

