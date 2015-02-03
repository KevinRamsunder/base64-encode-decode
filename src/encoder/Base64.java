package encoder;
public class Base64 {
   public static String encode(String inputString) {
      verifyInput(inputString);
      return new Base64Encoder(inputString).getEncodedString();
   }

   private static void verifyInput(String inputString) {
      if (inputString == null || inputString.length() == 0) {
         System.out.println("Invalid String.");
         System.exit(0);
      }
   }
}
