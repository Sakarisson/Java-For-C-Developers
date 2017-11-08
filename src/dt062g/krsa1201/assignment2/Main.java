package dt062g.krsa1201.assignment2;

public class Main {
    private static Point _point = new Point();
    private static Rectangle rect = new Rectangle(_point, "red");

    public static void main(String[] args) {
        System.out.println(_point.toString());
    }
}
