package FilePrac;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) {
		String path = "E:\\";
		Main wf = new Main();
		File f = new File(path);
		double size = wf.getFolderSize(f);
		if ( size < 1024) {
			System.out.format("%.2f B",size);
		}
		else if ( size < 1024*1024 && size >= 1024) {
			System.out.format("%.2f KB",size/1024);
		}else if ( size >= 1024*1024 && size < 1024*1024*1024) {
			System.out.format("%.2f MB",size/(1024*1024) );
		}else if ( size >= 1024*1024*1024) {
			System.out.format("%.2f GB",size/(1024*1024*1024));
		}
	}
	
	public double getFolderSize(File folder) {
	    long length = 0;
	    File[] files = folder.listFiles();
	    if (files == null || files.length == 0){
	        return length;
	    }
	    for (File file : files) {
	        if (file.isFile()) {
	            length += file.length();
	        } else {
	            length += getFolderSize(file);
	        }
	    }
	    return length;
	}
	

}
