package encoder;
public class BitDivider {

   private String[] sixBitDivision;

   public BitDivider(BitString bitstring) {
      sixBitDivision = divideInput(bitstring.getBitString());
   }

   private String[] divideInput(String bitstring) {
      int length = bitstring.length() / 6;
      String[] dividedBitString = new String[length];

      for (int i = 0; i < length; i++) {
         dividedBitString[i] = bitstring.substring(6 * i, 6 * (i + 1));
      }

      return dividedBitString;
   }

   public String[] getBits() {
      return sixBitDivision;
   }
}