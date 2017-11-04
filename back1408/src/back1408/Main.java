package back1408;
import java.io.*;
import java.util.StringTokenizer;
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		String start = br.readLine();
		String end = br.readLine();
		int startHour;
		int startMin;
		int startSec;
		int endHour;
		int endMin;
		int endSec;
		int resultHour = 0;
		int resultMin = 0;
		int resultSec = 0;
		
		StringTokenizer st;
		st = new StringTokenizer(start,":");
		startHour = Integer.parseInt(st.nextToken());
		startMin = Integer.parseInt(st.nextToken());
		startSec = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(end,":");
		endHour = Integer.parseInt(st.nextToken());
		endMin = Integer.parseInt(st.nextToken());
		endSec = Integer.parseInt(st.nextToken());
		
		if ( endHour > startHour) {
			if ( endSec >= startSec ) {
				resultSec = endSec - startSec;
			}
			else if( endSec < startSec) {
				resultSec = endSec - startSec+60;
				endMin -= 1;
			}
			if ( endMin >= startMin ) {
				resultMin = endMin - startMin;
			}
			else if( endMin < startMin) {
				resultMin = endMin - startMin+60;
				endHour -= 1;
			}
			resultHour = endHour - startHour;
		}
		else if ( endHour == startHour) {
			if ( endMin > startMin) {
				if ( endSec >= startSec ) {
					resultSec = endSec - startSec;
				}
				else if( endSec < startSec) {
					resultSec = endSec - startSec+60;
					endMin -= 1;
				}
				resultMin = endMin - startMin;
				resultHour = 0;
			}
			else if ( endMin == startMin) {
				if ( endSec >= startSec) {
					resultSec = endSec - startSec;
					resultMin = 0; resultHour = 0;
				}
				if ( startSec > endSec) {
					resultSec = 
				}
			}
		}
		System.out.format("%02d:%02d:%02d", resultHour,resultMin,resultSec);
	}
}
