public class monkey1 {
    
    private String name;
    private int arms;
    private String Color;
    public String getColor() {
        return Color;
    }
    public void setColor(String newColor) {
        this.Color = newColor;
    }
    public int getArms() {
        return arms;
    }

    public String getName() {
        return name;
    }
    public void setArms(int newArms) {
        this.arms = newArms;
    }
    public void setName(String newName) {
        this.name = newName;
    }
    public void display(){
        System.out.println(name);
        System.out.println("no.of arms : "+arms);
        System.out.println("color :"+ Color);
        System.out.println("");
    }

}
