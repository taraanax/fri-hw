package DN_06;

public class Tocka {

    private final double x;
    private final double y;

    public Tocka(double x, double y){
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args){
        Tocka t = new Tocka(2.0, -1.0);
        System.out.print(t);
    }

    public double vrniX(){Ł
        return this.x;
    }

    public double vrniY() {
        return this.y;
    }

    public String toString() {
        return String.format("(%.2f, %.2f)", x, y).replace(',','.').replace(". ", ", ");
    }

    public double razdalja(Tocka t) {
        return Math.hypot(t.x - this.x, t.y - this.y);
    }

    public static Tocka izhodisce() {
        return new Tocka(0,0);
    }

    public double razdaljaOdIzhodisca() {
        return razdalja(izhodisce());
    }

}
