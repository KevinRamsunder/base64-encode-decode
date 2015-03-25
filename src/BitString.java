public class BitString {

   private String bitString; // formatted bit string

   public BitString(String input) {
      // create a formatted bit string to prepare for encryption
      bitString = createBitString(input);
   }

   private String createBitString(String input) {
      byte[] array = input.getBytes(); // get binary data
      StringBuilder builder = new StringBuilder(); // string array

      // add each byte to the string array
      for (byte i : array) {
         // convert byte to its string representation
         String bitstring = Integer.toBinaryString((int) i);
         
         // set standard width of bit string to 8, and add to string array
         builder.append(addBinaryPadding(bitstring));
      }

      // add extra byte padding by the base64 encryption algorithm
      builder.append(addExtraPadding(input));
      
      return builder.toString(); // flatten array and return
   }

   private String addExtraPadding(String input) {
      /* 'extraPadding' formula finds the number of trailing bytes needed for all cases.
       * 
       * Each group of three characters are encoded together by Base64 Encryption,so:
       * 
       * Find the excess chars for modding by three, convert this to number of chars
       * needed by subtracting this value from three.
       * 
       * Include a final mod by three to handle the case where the input.length
       * is already a multiple of three. 
       */
      
      int extraPadding = (3 - (input.length() % 3)) % 3;
      
      return createBitPadding(extraPadding);
   }

   /** Standardize bit string to 8 digits. Required for base64 encryption */
   private String addBinaryPadding(String bitstring) {
      if (bitstring.length() >= 8) { // already 8, return
         return bitstring;
      }

      // calculate padding length, append the padding, and return new bit string
      int paddingLength = 8 - bitstring.length();
      return createPadding(paddingLength) + bitstring;
   }

   /** Helper to get 'paddingLength' zeroes to standardize bit string length */
   private String createPadding(int paddingLength) {
      StringBuilder padding = new StringBuilder(paddingLength);
      
      for (int i = 0; i < paddingLength; i++) {
         padding.append("0");
      }

      return padding.toString();
   }

   /** Add byte padding required for base64 encryption */
   private String createBitPadding(int remainder) {
      String padding = "00000000"; // byte representation
      StringBuilder result = new StringBuilder();

      for (int i = 0; i < remainder; i++) {
         result.append(padding);
      }

      return result.toString();
   }

   public String getBitString() {
      return bitString;
   }
}

