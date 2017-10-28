package back1316;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		in.nextLine();
		int result = 0;
		
		while ( T > 0 ) {
			char tmp[] = in.nextLine().toCharArray();
			int count = 0;
			int a = 0; int b = 0; int c = 0; int d = 0; int e = 0; int f = 0;
			int g = 0; int h = 0; int i = 0; int j = 0; int k = 0 ; int l = 0;
			int m = 0; int n = 0; int o = 0; int p = 0; int q = 0; int r = 0;
			int s = 0; int t = 0; int u = 0; int v = 0; int w = 0; int x = 0;
			int y = 0; int z = 0;
			while ( count < tmp.length-1 ) {
				if ( tmp[count] != tmp[count+1]) {
					switch(tmp[count])
					{
						case 'a': a++;break; case 'b':b++;break; case 'c':c++;break; case 'd':d++;break; case 'e':e++;break; case 'f':f++;break;
						case 'g': g++;break; case 'h':h++;break; case 'i':i++;break; case 'j':j++;break; case 'k':k++;break; case 'l':l++;break;
						case 'm': m++;break; case 'n':n++;break; case 'o':o++;break; case 'p':p++;break; case 'q':q++;break; case 'r':r++;break;
						case 's': s++;break; case 't':t++;break; case 'u':u++;break; case 'v':v++;break; case 'w':w++;break; case 'x':x++;break;
						case 'y': y++;break; case 'z':z++;break;
					}
				}
				count++;
			}
			switch(tmp[count])
			{
				case 'a': a++;break; case 'b':b++;break; case 'c':c++;break; case 'd':d++;break; case 'e':e++;break; case 'f':f++;break;
				case 'g': g++;break; case 'h':h++;break; case 'i':i++;break; case 'j':j++;break; case 'k':k++;break; case 'l':l++;break;
				case 'm': m++;break; case 'n':n++;break; case 'o':o++;break; case 'p':p++;break; case 'q':q++;break; case 'r':r++;break;
				case 's': s++;break; case 't':t++;break; case 'u':u++;break; case 'v':v++;break; case 'w':w++;break; case 'x':x++;break;
				case 'y': y++;break; case 'z':z++;break;
			}
			/*System.out.println(a+" "+b+" "+c+" "+d+" "+e+" "+f+" "+g);
			System.out.println(h+" "+i+" "+j+" "+k+" "+l+" "+m+" "+n);
			System.out.println(o+" "+p+" "+q+" "+r+" "+s+" "+t+" "+u);
			System.out.println(v+" "+w+" "+x+" "+y+" "+z);*/
			if ( a <= 1 && b <= 1 && c <= 1 && d <= 1 && e <= 1 && f <= 1 && g <= 1 && h <= 1 && i <= 1 && j <= 1 && k <= 1 && l <= 1 && 
					m <= 1 && n <= 1 && o <= 1 && p <= 1 && q <= 1 && r <= 1 && s <= 1 && t <= 1 && u <= 1 && v <= 1 && w <= 1 && x <= 1 && y <= 1 && z <= 1 ) {
				result++;
			}
			T--;
		}
		
		System.out.println(result);
	}
}
