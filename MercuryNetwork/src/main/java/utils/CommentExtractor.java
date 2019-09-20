package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * <h1>CommentExtractor</h1>
 * Prints out only the comments inside a given class 
 * <p>
 * 
 * @author  Dustin Norman
 * @since   07-12-2018
 */

public class CommentExtractor {

	/**
	 * @param args default args
	 * @throws IOException the exception
	 */
	public static void main(String[] args) throws IOException {
		removeComment();
	} // end main

	static void removeComment() throws IOException {
		
		try {
			
			String pkg = "baselineSecure";
			String file = "Secure_Users";

			// Get operating system
			String filePath = null;
			String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				os = "Windows";
				filePath = "C:\\Code\\VMP\\automatedtesting\\MercuryNetwork\\src\\test\\java\\"+pkg+"\\"+file+".java";
			} else if (os.contains("Mac")) {
				os = "Mac";
				filePath = "/Users/dnorman/Code/VMP/automatedtesting/MercuryNetwork/src/test/java/"+pkg+"/"+file+".java";
			} // end if/else

			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line;
			boolean comment = false;
			while ((line = br.readLine()) != null) {
				if (line.contains("/*")) {
					comment = true;
					continue;
				}
				if(line.contains("*/")){
					comment = false;
					continue;
				}
				if(line.contains("} //")){
					comment = false;
					continue;
				}
				if(line.contains("// TODO:")){
					comment = false;
					continue;
				}
				if(line.contains("Wait for busy to be hidden")){
					comment = false;
					continue;
				}
				if(line.contains("Close Related Orders popup")){
					comment = false;
					continue;
				}
				if(line.contains("Wait for")){
					comment = false;
					continue;
				}
				if(line.contains("Get out of iFrame")){
					comment = false;
					continue;
				}
				if(line.contains("Switch into iFrame")){
					comment = false;
					continue;
				}
				if(line.contains("Switch out of iFrame")){
					comment = false;
					continue;
				}
				if(line.contains("@Test")){
					System.out.println("\n\n");
				}
				if(line.contains("public void")){
					System.out.println("\n"+line);
				}
				if(line.contains("//")){
					System.out.println("	 * 	<li>" + line.replace("&", "&amp;").replace("//", "").replace("<", "&lt;").replaceAll(">", "&gt;").trim() + "</li>");
				}
				if(!comment){
//					System.out.println(line);
				}
			}
			br.close();
		} // end try
		catch (IOException e) {
			System.out.println("OOPS! File could not read!\n"+e);
		} // end catch
	} // end removeComment

} // end class
