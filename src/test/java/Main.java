import java.util.LinkedHashMap;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<Character,Integer>();
        while(in.hasNextLine()){
            String str = in.nextLine().trim();
            for (int i = 0; i < str.length(); i++) {
                if (map.keySet().contains(str.charAt(i))){
                    map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
                }else {
                    map.put(str.charAt(i), 1);
                }
            }
            int min = Integer.MAX_VALUE;
            for (Character character : map.keySet()){
                if (map.get(character) < min){
                    min = map.get(character);
                }
            }
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < str.length(); i++) {
                if (map.get(str.charAt(i)) != min){
                    buffer.append(str.charAt(i));
                }
            }
            System.out.println(buffer.toString());
        }
    }
}