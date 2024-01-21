package algo;

import java.util.ArrayList;
import java.util.List;

public class multiply {

    public static int multiplyNos(int a, int b){
        int smaller = Math.min(a, b);
        int bigger = Math.max(a, b);

        return helper(smaller, bigger);
    }

    public static int helper(int a, int b){
        if(a == 0){
            return 0;
        }
        if(a == 1){
            return b;
        }

        int half = a >> 1;
        int res = helper(half, b);

        return a%2 == 0? res + res : res+ res + b;
    }

    static List<List<String>> res = new ArrayList<>();

    public static List<List<String>> solveNQueens(int n) {
        res.clear();

        // i =0 ,j = 0 - 1st queen                 //set of conditions - row, column, diag
        // i, j+1 2nd queen and check conditions
        // if fail i, j + 2
        helper(n, 0, new ArrayList<String>());
        return res;
    }

    public static void helper(int n, int c, List<String> t) {

        if( n == c){
            res.add(new ArrayList<String>(t));
            return;
        }
        StringBuilder sb = new StringBuilder(n);
        //put cth queen at every i
        for(int i = 0; i < n; i++){

            //if can't' put queen continue
            if(!canPutQ(t, i)){
                continue;
            }

            //create a row with . and insert Q at ith
            //add row to t

            t.add(addQ(n, i));

            helper(n, c+1, t);

            t.remove(t.size()-1);

        }
        // i =0 ,j = 0 - 1st queen                 //set of conditions - row, column, diag
        // i, j+1 2nd queen and check conditions
        // if fail i, j + 2
    }

    private static String addQ(int n, int i){
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < i; j ++){
            sb.append('.');
        }
        sb.append('Q');
        for(int j = i + 1; j < n; j ++){
            sb.append('.');
        }

        return sb.toString();
    }

    private static boolean canPutQ(List<String> t, int r){
        if(t.size() == 0){
            return true;
        }

        //is ith row occupied

        for(String s : t){
            if(s.charAt(r) == 'Q'){
                return false;
            }
        }

        // is diag occupied <up, down>
        int u = r, l = r;
        for(int i = t.size() - 1; i >= 0; i--){
            String s = t.get(i);
            u = u-1;
            //check upper diag
            if( u >= 0 && s.charAt(u) == 'Q'){
                return false;
            }

            //check lower diag
            l = l+1;
            if( l < s.length() && s.charAt(l) == 'Q'){
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {

//        System.out.println(multiplyNos( 3, 4));
        System.out.println(solveNQueens(4));
    }
}
