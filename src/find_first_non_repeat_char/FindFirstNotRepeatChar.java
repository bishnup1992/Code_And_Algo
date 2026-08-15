package find_first_non_repeat_char;

import java.util.HashMap;
import java.util.Map;

public class FindFirstNotRepeatChar {
    public static void main(String[] args) {
        System.out.println("First non-repeating character -> " + getFirstNonRepeatChar("aaccdbbtsccb"));
    }
    private static Character getFirstNonRepeatChar(String s){
        if(s == null || s.isEmpty()){
            return null;
        }

        Map<Character,Integer> freqMap = new HashMap<>();
        //Count every Character
        for(char c: s.toCharArray()){
           /*
           if(freqMap.containsKey(c)){
               //Char already exist
               //increase its own count
               freqMap.put(c,freqMap.get(c)+1);
           }else {
               //first time seeing this char
               freqMap.put(c,1);
           }*/
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);// char c is already in the map, if yes it increases its count by 1, if not it adds it to the map with a count of 0+1=1
        }
        //As hashmap is not ordered, we need to check the original string order to find the first non-repeating character
        //and check if the count of that character is 1 in the frequency map return the first character with count 1
        //for count we are getting the value from 1st loop

        for(char c: s.toCharArray()){
            if(freqMap.get(c) == 1){
                return c;
            }
        }
        return null;
    }
}
