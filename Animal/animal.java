package Animal;
public class animal {
    public static void main(String[] args) {
        //Two types of monkey defined by name and color monkey1 and monkey2 respectively
     monkey1 m = new monkey1();
     monkey2 n = new monkey2();
        m.setArms(2);
        m.setColor("grey");
        m.setName("Langur monkey");
        m.display();
            n.setName("Macaque Monkey");
            n.setColor("brown");
            n.setArms(2);
            n.display();


    }
}
