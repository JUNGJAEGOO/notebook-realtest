package c.middle;

import java.util.*;

public class CalculateSalary {
	
	static HashMap<Integer,Double> hm = new HashMap<>();
	
	
	public static void main(String args[]) {
		
		hm.put(1,(double) -95);
		hm.put(2,(double) 10);
		hm.put(3,(double) 20);
		hm.put(4,(double) 30);
		hm.put(5,(double) 100);
	
		CalculateSalary one = new CalculateSalary();
		one.calcutateSalaries();
	}

	
	public double getSalaryIncrease(Employee employee) {
		
		long salary = employee.salary;
		int type = employee.type;
		double rate = hm.get(type);
		
		return employee.salary+ ( (double)employee.salary * rate / (double)100 );
	}
	
	public void calcutateSalaries() {
		long arr[] = { 1000000000, 100000000, 70000000, 80000000, 60000000 };
		String names[] = {"LeeDaeRi","KimManager","WhanDesign","ParkArchi","LeeDevelop"};
		
		Employee emp[] = new Employee[arr.length];
		for ( int i = 0 ; i < arr.length ; i++) {
			
			emp[i] = new Employee(names[i],i+1,arr[i]);
			
			System.out.println(names[i]+"="+(long)getSalaryIncrease(emp[i]));
			
		}
	}
	
	class Employee {
		
		private String name;
		private int type;
		private long salary;
		
		Employee(String name,int type,long salary){
			this.name = name;
			this.type = type;
			this.salary = salary;
		}
		
		public void setName(String name){
			this.name = name;
		}
		
		public String getName(){
			return name;
		}
		
		public void setType(int type){
			this.type = type;
		}
		
		public int getType(){
			return type;
		}
		
		public void setSalary(long salary){
			this.salary = salary;
		}
		
		public long getSalary(){
			return salary;
		}
		
		
	}
}
