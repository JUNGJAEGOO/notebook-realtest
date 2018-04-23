package threadprac;

public class Main {
	private int amount;
	
	public static void main(String args[]) {
		Main m1 = new Main();
		
		AmountThread t1 = new AmountThread(m1,true);
		AmountThread t2 = new AmountThread(m1,true);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
			
			System.out.println(m1.amount);
		}catch(Exception e) {
			
		}
	}
	
	public synchronized void  plus(int value) {
		amount+=value;
	}
	
	public void minus(int value) {
		amount-=value;
	}
	
	public int getAmount() {
		return amount;
	}
	
	Main(){
		amount = 0;
	}
	
}
