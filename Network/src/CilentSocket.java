
import java.util.*;
import java.io.*;
import java.net.*;

public class CilentSocket {
	
	static int port = 9999;
	
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		Socket socket;
		try {
			socket = new Socket("127.0.0.1",port);
			OutputStream os;
			OutputStreamWriter osw;
			System.out.println("you are connected!");
			
			while ( true ) {
			
				System.out.print("type your message : ");
				String str = in.nextLine();
				os = socket.getOutputStream();
				osw = new OutputStreamWriter(os);
				BufferedWriter bw = new BufferedWriter(osw);
				bw.write(str);
				bw.close();
				
				if ( str.equals("EXIT") ) {
					System.out.println("Finished");
					break;
				}
				
			}
			
			osw.close();
			os.close();
			socket.close();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}
}
