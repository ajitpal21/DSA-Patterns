// leetcode 246. Strobogrammatic Number ?

/* A strobogrammatic number is a number that looks the same when rotated 180 degrees (turned upside down).
   Some digits rotate to become another digit:

            0 → 0
            1 → 1
            6 → 9
            8 → 8 
            9 → 6

Digits that are NOT valid when rotated:
2, 3, 4, 5, 7

Given a string num representing a number, return true if num is strobogrammatic; otherwise return false.
*/
import java.util.*;

class leetcode_246{

     public static boolean isStrobogrammaticNumber(HashMap<Character,Character> map, String s){
           int i = 0;
           int j = s.length() - 1;

           while(i <= j){
              char left = s.charAt(i);
              char right = s.charAt(j);

              if(map.containsKey(left)){
                    if(map.get(left) != right){
                        return false;
                    }else{
                         i++;
                         j--;
                    }
              }else{
                 return false;
              }
           }
           return true;
    }
    public static void main(String[] args) {
         String s = "198861";
         String s1 = "198891";
         String s2 = "19261";

         HashMap<Character,Character> map = new HashMap<>();
            map.put('0','0');   
            map.put('1','1');
            map.put('6','9');
            map.put('8','8');
            map.put('9','6');
        
        System.out.println(isStrobogrammaticNumber(map,s));
        System.out.println(isStrobogrammaticNumber(map,s1));
        System.out.println(isStrobogrammaticNumber(map,s2));
    }
}