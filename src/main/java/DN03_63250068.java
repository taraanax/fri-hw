import java.util.Scanner;

public class DN03_63250068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int visina = sc.nextInt();
        int sirina = sc.nextInt();
        int k = sc.nextInt();

        long stPloscic = polaganje(visina, sirina, k);

        System.out.println(stPloscic);

        }

    private static long polaganje(int visina, int sirina, int k) {

        if (visina == 0 || sirina == 0) {
            return 0;
        }
        int najvecjaPloscica = (int) Math.pow(2, k);

         if (najvecjaPloscica > visina || najvecjaPloscica > sirina) {
             k--;
             return polaganje(visina, sirina, k);
         }

         if (visina % najvecjaPloscica == 0 && sirina % najvecjaPloscica == 0) {
            return (long) (visina / najvecjaPloscica) * (sirina / najvecjaPloscica);
        }

         long stPloscic = 0;

        if (visina % najvecjaPloscica == 0) {
            stPloscic += (long) (visina / najvecjaPloscica) * (sirina / najvecjaPloscica);
            stPloscic += polaganje(visina, sirina % najvecjaPloscica, k - 1);
        } else {
            stPloscic += polaganje(visina - (visina % najvecjaPloscica), sirina, k - 1);
            stPloscic += polaganje(visina % najvecjaPloscica, sirina, k - 1);
        }

         return stPloscic;
    }

}