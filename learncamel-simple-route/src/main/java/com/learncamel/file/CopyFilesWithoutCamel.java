package com.learncamel.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CopyFilesWithoutCamel {

	public static void main(String[] args) throws IOException {
		
		// create the file object to read the directory
		File inputDirectory = new File("data/input");
		File outputDirectory = new File("data/output");
		
		// read the files from the directories and iterate the file.
		File[] files = inputDirectory.listFiles();
		
		// create the output stream and read the file
		for(File source: files) {
			File dest = new File(
					outputDirectory.getPath() + File.separator + source.getName());
		
		
		// create the output stream to write the file
		
			OutputStream oStream = new FileOutputStream(dest);
			byte[] buffer = new byte[(int)source.length()];
			FileInputStream iStream = new FileInputStream(source);
			iStream.read(buffer);
			try {
				oStream.write(buffer);
		} finally {
			iStream.close();
			oStream.close();
		} 
		}
		// close the stream

	}

}
