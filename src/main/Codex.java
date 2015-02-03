package main;
public class Codex {

   private static int n = 0;
   private static final char[] map;

   static {
      map = new char[64];
      initMap();
   }

   private static void initMap() {
      fillUppercase();
      fillLowercase();
      fillNumbers();
      fillPadding();
   }

   private static void fillUppercase() {
      for (int i = 65; i < 65 + 26; i++) {
         map[n++] = (char) i;
      }
   }

   private static void fillLowercase() {
      for (int i = 97; i < 97 + 26; i++) {
         map[n++] = (char) i;
      }
   }

   private static void fillNumbers() {
      for (int i = 48; i < 48 + 10; i++) {
         map[n++] = (char) i;
      }
   }

   private static void fillPadding() {
      map[n++] = '+';
      map[n++] = '/';
   }

   public static char getChar(int i) {
      return map[i];
   }
}