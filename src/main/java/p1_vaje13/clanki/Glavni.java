package p1_vaje13.clanki;
import java.util.*;

public class Glavni {

    public static void urediPoLetuInNaslovu(List<Clanek> clanki) {
        clanki.sort((c1, c2) -> {
            int razlikaLet = c2.getLeto() - c1.getLeto();
            if (razlikaLet != 0) return razlikaLet;
            return c1.getNaslov().compareTo(c2.getNaslov());
        });
    }

    public static Set<Avtor> vsiAvtorji(Collection<Clanek> clanki) {
        Set<Avtor> avtorji = new HashSet<>();
        for (Clanek clanek : clanki) {
           avtorji.addAll(clanek.getAvtorji());
        }
        return avtorji;
    }

    public static Map<Avtor, List<Clanek>> clankiPoAvtorjih(Collection<Clanek> clanki) {
        Map<Avtor, List<Clanek>> map = new HashMap<>();

        for (Clanek clanek : clanki) {
            for (Avtor avtor : clanek.getAvtorji()) {
                map.putIfAbsent(avtor, new ArrayList<>());
                map.get(avtor).add(clanek);
            }
        }

        for (List<Clanek> seznam : map.values()) {
            urediPoLetuInNaslovu(seznam);
        }

        return map;
    }

    public static Avtor najplodnejsiAvtor(Collection<Clanek> clanki) {
        Map<Avtor, List<Clanek>> map = clankiPoAvtorjih(clanki);

        return Collections.max(map.entrySet(), Comparator.comparingInt(e -> e.getValue().size())
        ).getKey();
    }
}
