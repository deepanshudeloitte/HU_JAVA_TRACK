package reverse_of_a_list;
import java.util.*;


public class reverseString {
    static void reverse(String [] a){

        Collections.reverse(Arrays.asList(a));
        System.out.println(Arrays.asList(a));
    }
    public static void main(String[] args) {
        String []a = {"hashedin", "by", "deloitte","2022"};
        reverse(a);
    }
}
