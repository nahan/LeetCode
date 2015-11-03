import java.util.HashMap;
import java.util.Map.Entry;

/**
 * You are playing the following Bulls and Cows game with your friend: 
 * You write a 4-digit secret number and ask your friend to guess it. 
 * Each time your friend guesses a number, you give a hint. 
 * The hint tells your friend how many digits are in the correct positions (called "bulls") 
 * and how many digits are in the wrong positions (called "cows"). 
 * Your friend will use those hints to find out the secret number.
 * 
 * For example:
 * Secret number:  "1807"
 * Friend's guess: "7810"
 * Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
 * Write a function to return a hint according to the secret number and friend's guess, 
 * use A to indicate the bulls and B to indicate the cows. 
 * In the above example, your function should return "1A3B".
 * 
 * Please note that both secret number and friend's guess may contain duplicate digits, for example:
 * Secret number:  "1123"
 * Friend's guess: "0111"
 * In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, 
 * and your function should return "1A1B".
 * 
 * You may assume that the secret number and your friend's guess only contain digits, 
 * and their lengths are always equal.
 * @author Han
 *
 */
public class Solution {
    public String getHint(String secret, String guess) {
        StringBuilder builder = new StringBuilder();
        int bull = 0;
        int cow = 0;
        HashMap<Integer, Integer> secretHash = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> guessHash = new HashMap<Integer, Integer>();
        for (int i = 0; i < secret.length(); i++) {
            secretHash.put(i, secret.charAt(i) - 48);
            guessHash.put(i, guess.charAt(i) - 48);
        }
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == secret.charAt(i)) {
                bull++;
                secretHash.remove(i);
                guessHash.remove(i);
            }
        }
        for (Entry<Integer, Integer> item: guessHash.entrySet()) {
            if (secretHash.containsValue(item.getValue())) {
                cow++;
                int toDel = 0;
                for (Entry<Integer, Integer> subitem: secretHash.entrySet()) {
                    if (subitem.getValue() == item.getValue()) {
                        toDel = subitem.getKey();
                        break;
                    }
                }
                secretHash.remove(toDel);
            }
        }
        builder.append(bull);
        builder.append('A');
        builder.append(cow);
        builder.append('B');
        return builder.toString();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s;
        String g;
        
        s = "1807";
        g = "7810";
        System.out.format("%s, %s, -> %s\n", s, g, solution.getHint(s, g));
        
        s = "1123";
        g = "0111";
        System.out.format("%s, %s, -> %s\n", s, g, solution.getHint(s, g));
        
        s = "1122";
        g = "1222";
        System.out.format("%s, %s, -> %s\n", s, g, solution.getHint(s, g));
    }
}
