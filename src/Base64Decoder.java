public class Base64Decoder {

   private String output; // decoded value for user

   public Base64Decoder(String encodedString) {
      // Convert encoded data to bitstring
      String bitstring = getBitString(encodedString);

      // Decode values from the bitstring
      BitDecoder decoder = new BitDecoder(bitstring);

      // save results
      output = decoder.getResult();
   }

   private String getBitString(String encodedString) {
      StringBuilder decoder = new StringBuilder(encodedString.length());

      // go through each character and append base64 int values
      for (int i = 0; i < encodedString.length(); i++) {
         // convert ASCII char to base64 index
         int base64Value = Codex.getInt(encodedString.charAt(i));

         // If zero, this character is not defined in base64 encryption, skip
         // it!
         if (base64Value == 0) {
            continue;
         }

         // convert information and proper encodings, standardize padding,
         // append
         String bitstring = Integer.toBinaryString(base64Value); // bit string
         String finalInformation = addBinaryPadding(bitstring); // add padding
         decoder.append(finalInformation); // add result to array
      }

      return decoder.toString();
   }

   /** Standardize bit string to 6 digits. Required for base64 decoding */
   private String addBinaryPadding(String bitstring) {
      if (bitstring.length() >= 6) { // already 6, return
         return bitstring;
      }

      // calculate padding length, append the padding, and return new bit string
      int paddingLength = 6 - bitstring.length();
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

   public String getDecodedString() {
      return output;
   }
}