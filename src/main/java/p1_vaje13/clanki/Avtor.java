package p1_vaje13.clanki;
import java.util.*;

public class Avtor {
    private final String ime;
    private final String priimek;

    public Avtor(String ime, String priimek) {
        this.ime = ime;
        this.priimek = priimek;
    }

    @Override
    public String toString() {
        return this.ime + " " + this.priimek;
    }
}
