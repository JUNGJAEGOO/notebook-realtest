package back1152;
import java.util.*;
public class Main {

	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		
		String word = in.nextLine();
		
		char words[] =word.toCharArray();
		
		int count = 0;
		int index = 0;
		
		while ( index < words.length ) {
			
			if(words[index] == ' ') {
				int zerostart = index;
				while (words[index] == ' ' && index < words.length -1) {       //  빈칸이면 인덱스 그냥 올리고
					index++;
				}

			}
			if(words[index] != ' ') {
				
				while (words[index] != ' ' && index < words.length -1) {    // 단어면 인덱스 올리다가 단어의 마지막에 단어의 수 +1
					index++;
				}
				count++;

			}


			if ( index == words.length-1 ) { break; }    // 다 검색하면 종료
			
		}
		
		
		
		
		
		System.out.println(count);
	}
}
