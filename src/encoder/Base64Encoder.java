package encoder;

import main.Codex;

public class Base64Encoder {

   private String output;

   public Base64Encoder(String inputString) {
      BitString input = new BitString(inputString);
      BitDivider seperated = new BitDivider(input);
      output = encode(seperated);
   }

   private String encode(BitDivider dividedBits) {
      String[] listOfBits = dividedBits.getBits();
      StringBuilder builder = new StringBuilder(listOfBits.length);

      for (String i : listOfBits) {
         int index = Byte.valueOf(i, 2);
         builder.append(Codex.getChar(index));
      }

      return modifyFinalOutput(builder);
   }

   private String modifyFinalOutput(StringBuilder builder) {
      int length = builder.length();
      String padding = createEndPadding(builder.substring(length - 2));
      int start = builder.length() - padding.length();
      int end = builder.length();
      
      return builder.replace(start, end, padding).toString();
   }

   private String createEndPadding(String substring) {
      String padding = substring;

      if (substring.equals("AA")) {
         padding = "==";
      } else if (substring.charAt(1) == 'A') {
         padding = "=";
      }

      return padding;
   }

   public String getEncodedString() {
      return output;
   }
}