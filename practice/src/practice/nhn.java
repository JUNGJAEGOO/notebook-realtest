package practice;
import java.util.*;
import java.io.*;
public class nhn {
public static void main(String args[]) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
	StringTokenizer st;
	
	String tmp = br.readLine();
	int arr[] = new int[10];
	for( int j = 9 ; j > -1 ; j--) {
		arr[j] = -1;
	}
	int real[] = new int[20];

	st = new StringTokenizer(tmp," ");
	int count = 0;
	while(st.hasMoreTokens()) {
		arr[count] = Integer.parseInt(st.nextToken());
		count++;
	}

	
	for( int j = 19 ; j > -1 ; j--) {
		real[j] = -1;
	}
	

	for( int i = 0 ; i < 10 ; i++) {
		if ( arr[i]>= 10) {
			real[2*i] = arr[i]%10;
			real[2*i+1] = arr[i]/10;
		}
		else {
			real[2*i] = arr[i];
		}
	}
	

	Arrays.sort(real);
	int result = 0;
	String result1 = "";
	String result2 = "";
	
	for( int j = 19 ; j > -1 ; j--) {
		if ( real[j]!= -1) {
		System.out.print(real[j]);
		int tmp2 = real[j];
		result1 += Integer.toString(tmp2);
		}
	}
	System.out.println();
	int index = 0;
	boolean pass = false;

	
	

	int tmpp = -10;
	if ( index != -1) {
		int c = 0;
		while ( true) {
			if ( real[c] != 0 && real[c] != -1) {
				tmpp=c;
				break;
			}
			c++;
		}
		int tmppp = real[index];
		real[index] = real[tmpp];
		real[tmpp] = tmppp;
	}
	
	for( int j = 0 ; j < 20 ; j++) {
		if ( real[j]!= -1) {
		
		if ( real[j] == 0 && pass==false) { index = j; pass = true;}
		
		result2 += Integer.toString(real[j]);
		}
		
	}
	
	System.out.println(result2);
	System.out.print(real[index]);
	
	System.out.println();
	result = Integer.parseInt(result1) + Integer.parseInt(result2);
	System.out.println(result);
}
}
