package find_longest_substring_without_repeating_char;

import java.util.HashMap;
import java.util.Map;

public class FindLongestSubStingWithoutRepeatingChar {
    public static void main(String[] args) {
        String input = "daawpeaawpaad";
        int longestLength = getLongestSubStringWithoutRepeatingChar(input);
        System.out.println("Longest substring length without repeating characters: " + longestLength);
        String longestSubstring = getLongestSubStringWithoutRepeatingCharString(input);
        System.out.println("Longest substring without repeating characters: " + longestSubstring);
    }

    private static int getLongestSubStringWithoutRepeatingChar(String s){
        if(s == null || s.isEmpty()){
            return 0;
        }
        Map<Character,Integer> lastSeen = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        //Move the right pointer through the string
        for(int right = 0; right < s.length(); right++){
            char currChar= s.charAt(right);
            //if duplicate found move left after previous occurrence
            if(lastSeen.containsKey(currChar)){
                left = Math.max(left, lastSeen.get(currChar) + 1);
            }
            //store the latest index in current character
            lastSeen.put(currChar, right);
            // Calculate current window length
            int currentLength = right - left + 1;
            // Update maximum length
            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength;
    }

    private static String getLongestSubStringWithoutRepeatingCharString(String s){
        if(s == null || s.isEmpty()){
            return "";
        }
        Map<Character,Integer> lastSeen = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        int startIndex = 0;

        for(int right = 0; right < s.length(); right++){
            char currChar= s.charAt(right);
            if(lastSeen.containsKey(currChar)){
                left = Math.max(left, lastSeen.get(currChar) + 1);
            }
            lastSeen.put(currChar, right);
            int currentLength = right - left + 1;
            if(currentLength > maxLength){
                maxLength = currentLength;
                startIndex = left;
            }
        }
        return s.substring(startIndex, startIndex + maxLength);
    }
}
