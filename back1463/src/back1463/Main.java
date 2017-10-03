package back1463;

import java.util.Scanner;

public class Main{
	

    public static void main(String args[]){
       
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
    	int dp[] = new int[1000001];
        dp[2]=1;
        dp[3]=1;
        for(int i =4 ; i <= 100 ; i++){
            
        	if ( i%3==0 ){
            dp[i] = Math.min(dp[i-1]+1,dp[i/3]+1);
            }
            else if ( i%2==0 ){
            dp[i] = Math.min(dp[i-1]+1,dp[i/2]+1);
            }
            else {
            dp[i] = dp[i-1]+1;
            }
        	
        	//System.out.println(dp[i]);
              
        }
    	
        
    	System.out.println(dp[N]);
    }
    
}