package FileHandling;

import java.io.*;
import java.util.*;
public class dataHandling {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(new FileReader("C:\\Users\\deepanshusingh8\\HU_JAVA_TRACK\\FileHandling\\students.csv"));
            ArrayList<Candidate> candidate = new ArrayList<>();
            int i = 0;
            while (scan.hasNext()) {
                String[] str = scan.nextLine().split(",");
                if (i != 0) {
                    candidate.add(new Candidate(str[0], str[1], str[2], str[3], Integer.parseInt(str[4])));
                   
                }
                i++;
            }
            Collections.sort(candidate, (a, b)-> a.getRank()-b.getRank());
            
            for (i = 0; i < Math.min(5, candidate.size()); i++) {
                System.out.println(candidate.get(i));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }
}

class Candidate {
    private String name, rgN10, rgN12, btRgNo;
    private int rank;

    public Candidate(String name, String regNo10, String regNo12, String btechRegNo, int rank) {
        this.name = name;
        this.rgN10 = regNo10;
        this.rgN12 = regNo12;
        this.btRgNo = btechRegNo;
        this.rank = rank;

    }

    public String getName() {
        return name;
    }

    public String getRegNo10() {
        return rgN10;
    }

    public String getRgNo12() {
        return rgN12;
    }

    public String getBtechRegNo() {
        return btRgNo;
    }

    public int getRank() {
        return rank;
    }

    
    public String toString() {
        return name + " " + rgN10 + " " + getRgNo12() + " " + btRgNo + " " + rank;
    }
}
