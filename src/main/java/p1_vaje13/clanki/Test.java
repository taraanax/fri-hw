package p1_vaje13.clanki;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Avtor ana = new Avtor("Ana", "Novak");
        Avtor bine = new Avtor("Bine", "Kralj");

        Clanek c1 = new Clanek(List.of(ana), "Java", 2023);
        Clanek c2 = new Clanek(List.of(ana, bine), "Linux", 2022);
        Clanek c3 = new Clanek(List.of(bine), "C++", 2023);

        List<Clanek> clanki = new ArrayList<>(List.of(c1, c2, c3));

        System.out.println("Vsi avtorji:");
        System.out.println(Glavni.vsiAvtorji(clanki));

        System.out.println("\nClanki po avtorjih:");
        System.out.println(Glavni.clankiPoAvtorjih(clanki));

        System.out.println("\nNajplodnejsi avtor:");
        System.out.println(Glavni.najplodnejsiAvtor(clanki));

        Glavni.urediPoLetuInNaslovu(clanki);
        System.out.println("\nUrejeni clanki:");
        System.out.println(clanki);
    }
}
