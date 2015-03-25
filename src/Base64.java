/** Main Base64 application. Perform encode or decode and write to file */

public class Base64 {

   public static void main(String[] args) {
      // args[0] : function, either ENCODE or DECODE
      // args[1] : Input file 
      // args[2] : Output file
      verifyCmdLine(args);

      /* Perform task given by user */
      if (args[0].equalsIgnoreCase("ENCODE")) {
         encodeInputAndWriteToFile(args[1], args[2]);       
      }
      else if (args[0].equalsIgnoreCase("DECODE")) {
         decodeInputAndWriteToFile(args[1], args[2]);
      } 
      else {
         String error = "\nFirst argument is invalid. ENCODE or DECODE only.";
         System.out.println(error);
         return;
      }
   }
   
   /** Get input from input file, encode to Base64, write to output file */
   public static void encodeInputAndWriteToFile(String input, String output) {
      String fileContent = FileStream.fileToString(input); // get text from input
      String encodedContent = encode(fileContent); // encode to Base64
      FileStream.writeToFile(output, encodedContent); // write result to output file
   }
   
   /** Get input from input file, decode Base64 to plain text, write to output file */
   public static void decodeInputAndWriteToFile(String input, String output) {
      String fileContent = FileStream.fileToString(input); // get text from input
      String decodedContent = decode(fileContent); // decode to plain text
      FileStream.writeToFile(output, decodedContent); // write result to output file
   }

   /** Encode plain text into Base64 */
   public static String encode(String plaintext) {
      verifyInput(plaintext); // validate
      return new Base64Encoder(plaintext).getEncodedString();
   }

   /** Decode Base64 encoded string */
   public static String decode(String encodedText) {
      verifyInput(encodedText); // validate
      return new Base64Decoder(encodedText).getDecodedString();
   }

   /** Validate input string */
   private static void verifyInput(String inputString) {
      if (inputString == null || inputString.length() == 0) {
         System.out.println("\nInvalid input string.");
         System.exit(0);
      }
   }

   /** Validate user input */
   private static void verifyCmdLine(String[] args) {
      if (args.length < 3) { // argument check
         System.out.println();
         System.out.println("Incorrect command line arguments: <arg0> [ENCODE/DECODE] <arg1> input.txt <arg2> output.txt");
         System.exit(0);
      }
   }
}


