public class area {
    public static void main(String[] args) {
        circle c = new circle();
        c.radius = 7;
        triangle t = new triangle();
        t.base = 7;
        t.height=7;
        square s = new square();
        s.side=7;
        rectangle r = new rectangle();
        r.length=7;
        r.breadth=7;
        System.out.println("Area of circle : "+c.area());
        System.out.println("Area of triangle : "+t.area());
        System.out.println("Area of square : "+s.area());
        System.out.println("Area of rectangle : "+r.area());
    }
}
