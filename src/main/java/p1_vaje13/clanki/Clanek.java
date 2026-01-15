package p1_vaje13.clanki;
import java.util.*;

public class Clanek {
    private final List<Avtor> avtorji;
    private final String naslov;
    private final int leto;

    public Clanek(List<Avtor> avtorji, String naslov, int leto) {
        this.avtorji = avtorji;
        this.naslov = naslov;
        this.leto = leto;
    }

    public int getLeto() {
        return this.leto;
    }

    public String getNaslov() {
        return this.naslov;
    }

    public List<Avtor> getAvtorji() {
        return this.avtorji;
    }

    @Override
    public String toString() {
        String strAvtorji = this.avtorji.toString();
        return String.format("%s: %s (%d)",
                strAvtorji.substring(1, strAvtorji.length() - 1), this.naslov, this.leto);
    }
}
