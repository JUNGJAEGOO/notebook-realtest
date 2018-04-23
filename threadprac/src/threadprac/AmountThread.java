package threadprac;

public class AmountThread extends Thread{
	private Main calc;
	private boolean addFlag;
	
	AmountThread(Main calc,boolean addFlag){
		this.calc = calc;
		this.addFlag = addFlag;
	}
	
	public void run() {
		for ( int i = 0 ; i < 10000 ; i++) {
			if ( addFlag) {
				calc.plus(1);
			}else {
				calc.minus(1);
			}
		}
	}
}
