package ua.goit.timonov.hometask_09;

/**
 * Provides ciphering and unciphering text with Caesar algorithm
 */
public class CaesarTextCipher {

    public static final int NUMBER_OF_LETTERS = 26;
    public static final int INT_OF_CHAR_A_LOWER_CASE = (int) 'a';

    /**
     * 
     * @param inputText
     * @param key
     * @return
     */
    public String encode(String inputText, int key) {
        char[] charArray = inputText.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char ch : charArray) {
            int ciphered = ((int) ch + key - INT_OF_CHAR_A_LOWER_CASE) % NUMBER_OF_LETTERS + INT_OF_CHAR_A_LOWER_CASE;
            ch = (char) ciphered;
            builder.append(ch);
        }
        return builder.toString();
    }

    /**
     *
     * @param inputText
     * @param key
     * @return
     */
    public String decode(String inputText, int key) {
        char[] charArray = inputText.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char ch : charArray) {
            int unciphered = ((int) ch - key - INT_OF_CHAR_A_LOWER_CASE + NUMBER_OF_LETTERS) %
                    NUMBER_OF_LETTERS + INT_OF_CHAR_A_LOWER_CASE;
            ch = (char) unciphered;
            builder.append(ch);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        CaesarTextCipher caesarTextCipher = new CaesarTextCipher();
        String text = "abcdefuvwxyz";
        System.out.println(text);
        String encoded = caesarTextCipher.encode(text, 5);
        System.out.println(encoded);
        String decoded = caesarTextCipher.decode(encoded, 5);
        System.out.println(decoded);
    }
}
