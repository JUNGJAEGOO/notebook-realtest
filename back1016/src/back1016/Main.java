package back1016;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		  // 1000000000000
		long min = in.nextLong();
		long max = in.nextLong();
		boolean result[] = new boolean[1000001];
		long dp[] = new long[1000001];
		
		if ( min==1 && max==1) {
			System.out.println(1);
			return;
		}
		
	    long sq_max = (long) Math.sqrt(max);    //범위 내 제곱값이 될 수 있는 가장 큰수
	    long cntNum =0;                        //제곱들의 개수
	    for(long i=2; i<=sq_max; i++) {        //제곱들 저장
	        dp[(int) i] = i*i;
	        cntNum++;
	    }


		int count = 0;
	    for(int i=2; i<cntNum+2; i++){
	    	 
	       long div_min = min;                 //div_min을 범위의 최소값 min으로 둔 후 
	        if(div_min % dp[i] != 0){               //div_min이 제곱수로 나누어 지지 않으면 
	            div_min = (min/dp[i] + 1) * dp[i]; //최소값을 제곱근으로 나눈 몫에 +1 후 다시 곱해서 범위 안의 값으로 바꾼다.
	        }
	 
	        
	        for(long tmp = div_min; tmp <=max; tmp += dp[i]){ //num[i]로 나누어지는 div_min을 count 한다.
	            if(!result[(int) (tmp-min)]){
	                result[(int) (tmp-min)] = true;
	                count++;
	            }
	        }
	 
	    }


		
		System.out.println(max-min-count+1);
	}
}
