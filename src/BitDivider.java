public class BitDivider {

   private String[] sixBitDivision;  

   public BitDivider(BitString bitstring) {
      // take bit string, make partitions of size 6, and store values
      sixBitDivision = divideInput(bitstring.getBitString());
   }

   /** Take bit string and return an array of partitioned bit strings, 
    * each of length 6, following the Base64 encryption algorithm.
    */
   private String[] divideInput(String bitstring) {
      int length = bitstring.length() / 6; // number of partitions
      String[] dividedBitString = new String[length];

      // get each partition of size 6 and add to array
      for (int i = 0; i < length; i++) {
         dividedBitString[i] = bitstring.substring(6 * i, 6 * (i + 1));
      }

      return dividedBitString;
   }

   public String[] getBits() {
      return sixBitDivision;
   }
}

