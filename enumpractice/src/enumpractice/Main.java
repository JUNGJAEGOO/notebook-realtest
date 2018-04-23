package enumpractice;

import java.util.Scanner;

public class Main {

	enum HealthInsurance {
		
		LEVEL_ONE(1000,1.0),
		LEVEL_TWO(2000,2.0),
		LEVEL_THREE(3000,3.2),
		LEVEL_FOUR(4000,4.5),
		LEVEL_FIVE(5000,5.6),
		LEVEL_SIX(6000,7.1);
		int maxSalary;
		double ratio;
		HealthInsurance(int maxSalary,double ratio){
			this.maxSalary = maxSalary;
			this.ratio = ratio;
		};
		
		double getRatio(){
			return this.ratio;
		}
		
		double getHealthInsurance(){
			return this.maxSalary;
		}
		
	}
	
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		System.out.println(getHealthInsurance(N)+" "+getHealthInsurance(N).ratio);
		
		int salaryArray[] = {1500,5500,8000};
		HealthInsurance arr[] = new HealthInsurance[3];
		for (int i = 0 ; i <3 ; i++) {
			arr[i] = getHealthInsurance(salaryArray[i]);
		}
		
		for ( int i = 0 ; i < 3 ; i++) {
			System.out.println(salaryArray[i]+"="+arr[i]+","+arr[i].getRatio());
		}
	}
	
	public static HealthInsurance getHealthInsurance(int salary) {
		
		HealthInsurance x = null;
		
		if ( salary <= 1000) {
			x = HealthInsurance.LEVEL_ONE;
		}else if ( salary > 1000 && salary <= 2000) {
			x = HealthInsurance.LEVEL_TWO;
		}else if ( salary > 2000 && salary <= 3000) {
			x = HealthInsurance.LEVEL_THREE;
		}else if ( salary > 3000 && salary <= 4000) {
			x = HealthInsurance.LEVEL_FOUR;
		}else if ( salary > 4000 && salary <= 5000) {
			x = HealthInsurance.LEVEL_FIVE;
		}else if ( salary > 5000) {
			x = HealthInsurance.LEVEL_SIX;
		}
		
		return x;
		
	}
	
}
