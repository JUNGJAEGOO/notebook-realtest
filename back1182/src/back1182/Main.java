package back1182;
import java.util.*;

public class Main {
	
	static int S;
	static int N;
	static int arr[];
	static int result = 0;
	
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		S = in.nextInt();
		arr= new int[N+1];
		for ( int i = 0 ; i < N ; i++ ) {
			arr[i] = in.nextInt();
		}
	
		
		int tmp[] = new int[N];
		for(int i = 1 ; i<arr.length;i++) {
		tmp[0] = arr[i];
		 back(0,tmp,0,i);
		}
		
		System.out.println(result);
	}
	
	public static boolean back(int start,int tmp[],int count,int length) {
		if (count == length) {
/*			for(int i = 0 ; i < tmp.length ; i++) {
			if( tmp[i]!=0) {
			System.out.print(tmp[i]+" ");
			}
			}
			System.out.println();*/
			int sum = 0;
			for(int i = 0 ; i < tmp.length ; i++) {
				sum += tmp[i];
			}
/*			System.out.println(sum);
			System.out.println(S);*/
			if( sum == S ) { result++; }
			return true;
		}else if(count != length){
			for ( int i = start ; i < N ; i++) {
				tmp[count] = arr[i];
				back(i+1,tmp,count+1,length);
			}
		}
		
		return false;
	}
}
