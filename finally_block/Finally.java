package finally_block;

public class Finally {
    static void meth1()throws Exception
    {
        try
        {

            System.out.println(10/0);
        }
        catch(ArithmeticException e){
            System.out.println(e);
        }
        finally
        {

            System.out.println("Thank You");
        }

    }
    public static void main(String[] args) throws Exception
    {
        meth1();
    }
}
