public class Base64Encoder {

   private String output; // encoded value for user

   public Base64Encoder(String plaintext) {
      // convert string to binary representation
      BitString input = new BitString(plaintext);

      // partition binary data by base64 algorithm
      BitDivider seperated = new BitDivider(input);

      // encode the partitioned data
      output = encode(seperated);
   }

   /** Encode the binary data into Base64 */
   private String encode(BitDivider dividedBits) {
      String[] listOfBits = dividedBits.getBits(); // get bit partitions
      StringBuilder builder = new StringBuilder(listOfBits.length);

      /** Convert each bit partition to its base64 char-set representation */
      for (String i : listOfBits) {
         int index = Byte.valueOf(i, 2); // calculate integer value of bit string
         builder.append(Codex.getChar(index)); // convert bits to base64 char-set
      }

      return modifyFinalOutput(builder); // add padding if needed and return
   }

   /** Examine final characters and determine if padding is needed */
   private String modifyFinalOutput(StringBuilder builder) {
      int length = builder.length();

      // examine last two characters
      String padding = createEndPadding(builder.substring(length - 2));

      // if a padding is required, replace the end of the string with the
      // padding
      int start = builder.length() - padding.length();
      int end = builder.length();

      return builder.replace(start, end, padding).toString();
   }

   /** Look at the current output and determine if padding is required. */
   private String createEndPadding(String substring) {
      String padding = substring;

      // padding is required if the last two characters satisfy these conditions
      // '=' is the padding character
      if (substring.equals("AA")) {
         padding = "==";
      } else if (substring.charAt(1) == 'A') {
         padding = "=";
      }

      return padding;
   }

   /** Get final Base64 representation of input string */
   public String getEncodedString() {
      return output;
   }
}
