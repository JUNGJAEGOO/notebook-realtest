import java.io.*;

public class Main {
	public static void main(String args[]) {
		Main manager = new Main();
		String fullPath = "E:\\godofjava" + File.separator +"text" + File.separator +"serial.obj";
		//SerialDTO dto = new SerialDTO("GodOfJavaBook",1,true,100);
		//manager.saveObject(fullPath, dto);
		manager.loadObject(fullPath);
	}
	
	public void loadObject(String fullPath) {
		//System.out.println(fullPath);
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(fullPath);
			ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			SerialDTO dto = (SerialDTO) obj;
			System.out.println("Load Success");
			System.out.println(dto);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			
			if ( ois!= null) {
				try {	
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if ( fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void saveObject(String fullPath,SerialDTO dto) {
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(fullPath);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(dto);
			System.out.println("Write Success");
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			
			if ( oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if ( fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
