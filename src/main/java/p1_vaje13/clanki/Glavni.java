package p1_vaje13.clanki;
import java.util.*;

public class Glavni {

    public static void urediPoLetuInNaslovu(List<Clanek> clanki) {
        clanki.sort((c1, c2) -> {
            int razlikaLet = Integer.compare(c2.getLeto(), c1.getLeto());
            if (razlikaLet != 0) return razlikaLet;
            return c1.getNaslov().compareTo(c2.getNaslov());
        });
    }

    public static Set<Avtor> vsiAvtorji(Collection<Clanek> clanki) {
        Set<Avtor> avtorji = new HashSet<>();
        for (Clanek c : clanki) {
           avtorji.addAll(c.getAvtorji());
        }
        return avtorji;
    }

    public static Map<Avtor, List<Clanek>> clankiPoAvtorjih(Collection<Clanek> clanki) {
        Map<Avtor, List<Clanek>> map = new HashMap<>();

        for (Clanek c : clanki) {
            for (Avtor a : c.getAvtorji()) {
                map.putIfAbsent(a, new ArrayList<>());
                map.get(a).add(c);
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
