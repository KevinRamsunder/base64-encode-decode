import java.io.*;
import java.nio.file.*;

public class FileStream {
   
   /** Simple textFile to String implementation */
   public static String fileToString(String filename) {
      String fileContent = null;
      
      try {
         // One-liner for reading all content from file
         fileContent = new String(Files.readAllBytes(Paths.get(filename)));
      } catch (IOException e) {
         error(e); // print error message and quit
      }
      
      return fileContent;
   }
   
   /** Write content 'content' to file 'filename' */ 
   public static void writeToFile(String filename, String content) {
      PrintWriter outStream = null; // outStream for writing to file
      
      try {
         // init outStream with given filename
         outStream = new PrintWriter(new FileOutputStream(filename));
         outStream.write(content); // write message to file
         outStream.close(); // close stream
      } catch (FileNotFoundException e) {
         error(e); // print error message and quit
      }
   }
   
   /** Display error message and then quit program */
   private static void error(Exception e) {
      System.out.println();
      System.out.println(e.getLocalizedMessage());
      System.exit(0);
   }
}