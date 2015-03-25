public class BitDecoder {

   private String result; // decoded data

   public BitDecoder(String bitstring) {
      // take bit string, make partitions of size 8, and store values
      result = convertInput(bitstring);
   }

   /** Take bit string, take partitions of length 8, and decode their values */
   private String convertInput(String bitstring) {
      int length = bitstring.length() / 8; // number of partitions
      char[] result = new char[length];

      // get each partition of size 8 and add to array
      for (int i = 0; i < length; i++) {
         String byteString = bitstring.substring(8 * i, 8 * (i + 1));
         int byteValue = Integer.parseInt(byteString, 2); // convert byte to int
         
         // convert value to ASCII character and add to char array
         result[i] = (char) byteValue; 
      }

      return new String(result); // flatten and return
   }

   public String getResult() {
      return result;
   }
}