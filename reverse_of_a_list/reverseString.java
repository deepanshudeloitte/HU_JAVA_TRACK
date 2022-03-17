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
<<<<<<< HEAD
=======

>>>>>>> 555b9c68eb7ab3e5e73b8a13c6676a7e02c64d4b
}
