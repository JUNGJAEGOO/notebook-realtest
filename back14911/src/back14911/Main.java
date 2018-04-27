package back14911;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String info[] = in.nextLine().split(" ");
		int arr[] = new int[info.length];
		for (int i = 0 ; i < arr.length ; i++) {
			arr[i] = Integer.parseInt(info[i]);
		}
		
		int target = in.nextInt();
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = left+1;
		
		int sum = 0;
		
		ArrayList<String> list = new ArrayList<>();
		
		while ( true ) {
			
			if ( arr[left] + arr[right] == target) {
				//System.out.println(arr[left]+" "+arr[right]);
				if (!list.contains(String.valueOf(arr[left]+" "+String.valueOf(arr[right])))) {
					list.add(String.valueOf(arr[left]+" "+String.valueOf(arr[right])));
				}
				
				right++;
				
			}else {
				right++;
			}
			
			if ( right == arr.length) {
				left++;
				right = left+1;
			}
			
			if ( left == arr.length - 1) {
				break;
			}
		}
		
		for ( int i = 0 ; i < list.size() ; i++) {
			System.out.println(list.get(i));
		}
		System.out.println(list.size());
		
	}
}
