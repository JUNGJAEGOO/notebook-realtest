package back3040;

import java.util.*;
public class Main{
    static int arr[];
    static int tmp[];
    static int result[];
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        
        arr = new int[9];
        tmp = new int[7];
        result = new int[7];
        for(int i = 0 ; i < 9 ; i++){
            arr[i] = in.nextInt();
        }
            

             for ( int i = 0 ; i < 9 ; i++){
            	 tmp[0] = arr[i];
                 boolean result = back(i,1);

                 if ( result == true ){

                     break;
                 }
             }
            
             for(int j = 0 ; j< 7 ; j++){
                 System.out.println(result[j]);
              }
        
    }
    
    public static boolean back(int start,int count){
        if ( count == 7){
            int sum=0;
            for ( int i=0;i<7;i++){
            	//System.out.print(tmp[i]+" ");
                sum+=tmp[i];
            }
            //System.out.println();
            if ( sum==100){
            	//ystem.out.println("맞습니다.");
            	for(int i = 0 ; i <7 ; i++) {
            		result[i] = tmp[i];
            	}
                return true;
            }
        }
        else {
           for( int i = start+1 ; i < 9 ; i++){
           tmp[count] = arr[i];
           back(i,count+1);
           }
        }
        
        return false;
    }
    
}