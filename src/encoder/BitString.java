package encoder;

public class BitString {

   private String bitString;

   public BitString(String input) {
      bitString = createBitString(input);
   }

   private String createBitString(String input) {
      byte[] array = input.getBytes();
      StringBuilder builder = new StringBuilder();

      for (byte i : array) {
         String bitstring = Integer.toBinaryString((int) i);
         builder.append(addBinaryPadding(bitstring));
      }

      int r = (3 - (input.length() % 3)) % 3;
      builder.append(createBitPadding(r));
      return builder.toString();
   }

   private String addBinaryPadding(String bitstring) {
      if (bitstring.length() == 8) {
         return bitstring;
      }

      int paddingLength = 8 - bitstring.length();
      return createPadding(paddingLength) + bitstring;
   }

   private String createPadding(int paddingLength) {
      StringBuilder padding = new StringBuilder(paddingLength);

      for (int i = 0; i < paddingLength; i++) {
         padding.append("0");
      }

      return padding.toString();
   }

   private String createBitPadding(int remainder) {
      String padding = "00000000";
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