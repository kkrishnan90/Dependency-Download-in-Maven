package org.maidsafe.test;
import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI; //Note this is URI, not URL
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import javax.print.URIException;
/**
 * Hello world!
 *
 */
public class App 
{
	static String dirName = "/Users/krish/Downloads/";
	public static void main(String[] args) throws IOException, InterruptedException {

		 // Make sure that this directory exists
		
		 String name="";
		 @SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		 	System.out.println("Enter some value here : ");
		 	name=scanner.next();
		 
		 System.out.println("Downloading - "+name+".pdf");
	 	@SuppressWarnings("resource")
		
		String nextline=scanner.nextLine();
		if(nextline!=null)
		{
		System.out.println("One good baked download file : "+name+".pdf coming right now...");
		saveFileFromUrlWithJavaIO(
		 dirName + name,
		 "https://www.tutorialspoint.com/android/android_tutorial.pdf");
		}
	}

	private static void saveFileFromUrlWithJavaIO(String string, String string2) throws MalformedURLException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		BufferedInputStream in = null;
		 FileOutputStream fout = null;
		 
		 try {
		 in = new BufferedInputStream(new URL(string2).openStream());
		 fout = new FileOutputStream(string);
		 //printProgress(0);
		 URL url = new URL(string2);
	     URLConnection conn = url.openConnection();
	    int size = conn.getContentLength();
		byte data[] = new byte[1024];
		 int count;
		 double percentage=0.0;
		 double sumCount = 0.0;
		 System.out.println("Downloading to : "+dirName);
		 
		 System.out.println("File size calculated : "+size+" is the file size");
		 while ((count = in.read(data, 0, 1024)) != -1) {
			 fout.write(data, 0, count);
			 double temp=Math.round((sumCount/size*100)*100)/100;
			 sumCount += count;
			 percentage=sumCount/size*100;
			 double rounded=Math.round(percentage*100);
			 double final_percentage=rounded/100;
			 System.out.println("Downloading in progress : "+final_percentage +"% completed..");
		}
		 
		 
		 while ((count = in.read(data, 0, 1024)) != -1) {
		
		 
		 }
		 } finally {
		System.out.println("Download completed successfully ..... ");
		 if (in != null)
		 in.close();
		 if (fout != null)
		 fout.close();
		 }
	}
	
}
