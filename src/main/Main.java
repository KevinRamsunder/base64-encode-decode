package main;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import encoder.Base64;

public class Main {

   public static void main(String[] args) throws IOException {
      if (args.length == 0) {
         System.out.println("No command line argument; <arg0> filename");
         System.exit(0);
      }

      String textfile = fileToString(args[0]);
      System.out.println(Base64.encode(textfile));
   }

   private static String fileToString(String filename) throws IOException {
      return new String(Files.readAllBytes(Paths.get(filename)));
   }
}
