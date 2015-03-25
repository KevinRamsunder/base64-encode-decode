public class Codex {
 
   // map contains base64 conversion table, used for encoding
   private static int mapIndex = 0; // index for encoding map
   private static final char[] map;

   // map contains conversion table for decoding
   private static final int[] inverseMap;

   /** Static Initializer Block */
   static {
      // 64 characters needed for encoding
      map = new char[64];
      
      // 128 needed to accommodate all ASCII chars, however only 64 fields are used
      inverseMap = new int[128];

      /* Create two arrays:
       * 'map' which maps Base64 numbers (0-63) to ASCII chars and,
       * 'inverseMap' which maps ASCII chars to their respective Base64 numbers (0-63) value.
       */
      initMaps();
   }

   /** Get character at index i from map */
   public static char getChar(int i) {
      if(i < 0 || i >= 64) return '\0'; // error checking, null char
      return map[i];
   }
   
   /** Get Base64 value from ASCII character */
   public static int getInt(char c) {
      if(c < 0 || c >= 128) return 0; // error checking, 0 denotes error
      return inverseMap[c];
   }
   
   private static void initMaps() {
      fillUppercase();
      fillLowercase();
      fillNumbers();
      fillPadding();
   }

   /** Add all Upper case characters to Map, and link ASCII values to InverseMap */
   private static void fillUppercase() {
      // 26 characters, ASCII 65 is the first uppercase char, 'A'
      for (int i = 65; i < 65 + 26; i++) {
         char toInsert = (char) i;

         map[mapIndex] = toInsert;
         inverseMap[toInsert] = mapIndex++;
      }
   }

   /** Add all Lower case characters to Map, and link ASCII values to InverseMap */
   private static void fillLowercase() {
      // 26 characters, ASCII 97 is the first lowercase char, 'a'
      for (int i = 97; i < 97 + 26; i++) {
         char toInsert = (char) i;

         map[mapIndex] = toInsert;
         inverseMap[toInsert] = mapIndex++;
      }
   }

   /** Add all Numbers to Map, and link ASCII values to InverseMap */
   private static void fillNumbers() {
      // 10 numbers, ASCII 48 is the first number, '0'
      for (int i = 48; i < 48 + 10; i++) {
         char toInsert = (char) i;

         map[mapIndex] = toInsert;
         inverseMap[toInsert] = mapIndex++;
      }
   }

   /** Add padding characters to Map, and link ASCII values to InverseMap */
   private static void fillPadding() {
      map[mapIndex] = '+';
      inverseMap['+'] = mapIndex++;
      
      map[mapIndex] = '/';
      inverseMap['/'] = mapIndex++;
   }
}