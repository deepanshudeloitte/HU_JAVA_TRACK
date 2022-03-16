import java.util.*;
public class loop {
    public static void main(String[] args) {
        int i,j,k;
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the numbers of rows you want to print : ");
        int n= sc.nextInt();
        for(i=0;i<n;i++)
        {
            for(j=0;j<n-i;j++){
                System.out.print(" ");
            }
            if(i%2==0){
                for(k=0;k<=i;k++){
                    System.out.print("*");
                }
            }else{
                for(k=0;k<=i;k++){
                    System.out.print("*");
                }
            }
            System.out.println("");
        }

        for(i=n-1;i>0;i--)
        {
            for(j=n;j>=i;j--){
                System.out.print(" ");
            }
            if(i%2==0){
                for(k=i;k>0;k--){
                    System.out.print("*");
                }
            }else{
                for(k=i;k>0;k--){
                    System.out.print("*");
                }
            }
            System.out.println("");
        }
    }
}
