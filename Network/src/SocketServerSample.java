
import java.io.*;
import java.net.*;

public class SocketServerSample {
	
	static Socket client;
	static ServerSocket server_socket;
	static int port = 9999;
	static String host = "127.0.0.1";
	static InputStreamReader isr;
	static BufferedReader br;
	static InputStream is;
	
	public static void main(String args[]) {
		
		try {
			
			server_socket = new ServerSocket(port);
			System.out.println("Server is started");
			
			while ( true ) {
				client = server_socket.accept();
				System.out.println("client is connected");
				
				is = client.getInputStream();
				isr = new InputStreamReader(is);
				br = new BufferedReader(isr);
				
				StringBuilder sb = new StringBuilder();
				int cnt = 0;
				while ( true ) {
					String str = br.readLine();
					if ( str == null) {
						break;
					}else {
						sb.append(str+"\n");
						cnt++;
					}
				}
				
				System.out.print(sb);
				if ( cnt == 1 && sb.toString().equals("EXIT") ) {
					
					is.close();
					isr.close();
					br.close();
					client.close();
					server_socket.close();
					break;
					
				}
				
				
			}
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
}
