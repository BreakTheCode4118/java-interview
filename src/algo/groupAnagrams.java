package algo;

import java.util.Arrays;
import java.util.Comparator;

public class groupAnagrams {
    public static void sort(String[] strs){
        Arrays.sort(strs, new anagramComp());
    }


    public static void main(String[] args) {
        String[] arr = new String[]{"eat","tea","tan","ate","nat","bat"};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
class anagramComp implements Comparator<String> {
    private String sort(String s){
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public int compare(String a, String b){
        return sort(a).compareTo(sort(b));
    }
}


