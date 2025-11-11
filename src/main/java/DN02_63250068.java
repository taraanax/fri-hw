import java.util.Scanner;

public class DN02_63250068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int oblika = sc.nextInt();
        int velikost = sc.nextInt();
        int stTipk = sc.nextInt();
        int[] tipke = new int[stTipk];

        for (int i = 0; i < stTipk; i++) {
            tipke[i] = sc.nextInt();
        }

        System.out.println(dolzinaPoti(oblika, velikost, tipke));

    }

    /// Vrne dolžino poti po dani tipkovnici glede na tip in dolžino tipkovnice ter pritisnjene tipke.
    public static int dolzinaPoti(int type, int size, int[] MovesArr) {
        return switch (type) {
            case 1 -> dolzinaPotiRavnovrstnica(MovesArr);
            case 2 -> dolzinaPotiKvadratnica(size, MovesArr);
            case 3 -> dolzinaPotiPiramidnica(MovesArr);
            case 4 -> dolzinaPotiSpiralnica(size, MovesArr);
            default -> -1;
        };
    }

    public static int dolzinaPotiRavnovrstnica(int[] tabela) {
        int razdalja = 0;
        for (int i = 0; i < tabela.length - 1; i++) {
            razdalja += Math.abs(tabela[i] - tabela[i + 1]);
        }
        return razdalja;
    }

    public static int dolzinaPotiKvadratnica(int size, int[] tabela) {
        int razdalja = 0;
        int zacVrsta;
        int zacStolp;
        int koncVrsta;
        int koncStolp;

        for (int i = 0; i < tabela.length - 1; i++) {
            zacVrsta = tabela[i] / size;
            zacStolp = tabela[i] % size;
            koncVrsta = tabela[i + 1] / size;
            koncStolp = tabela[i + 1] % size;

            razdalja += Math.abs(zacVrsta - koncVrsta) + Math.abs(zacStolp - koncStolp);
        }
        return razdalja;
    }

    public static int dolzinaPotiPiramidnica(int[] tabela) {
        int razdalja = 0;

        for (int i = 0; i < tabela.length - 1; i++) {

            int zacY = 0;
            int zacX = 0;
            int stevec1 = 0;

            while (tabela[i] >= stevec1 + (2 * zacY + 1)) {
                stevec1 += 2 * zacY + 1;
                zacY += 1;
            }
            zacX = tabela[i] - stevec1 - zacY;

            int koncY = 0;
            int koncX = 0;
            int stevec2 = 0;

            while (tabela[i + 1] >= stevec2 + (2 * koncY + 1)) {
                stevec2 += 2 * koncY + 1;
                koncY += 1;
            }
            koncX = tabela[i + 1] - stevec2 - koncY;

            razdalja += Math.abs(zacX - koncX) + Math.abs(zacY - koncY);
        }
        return razdalja;
    }


    private static int dolzinaPotiSpiralnica(int size, int[] tabela) {
        int razdalja = 0;
        for (int i = 0; i < tabela.length - 1; i++) {

            int zacTipka = tabela[i];
            int koncTipka = tabela[i + 1];

            int zacKoren = (int) Math.sqrt(zacTipka);
            int koncKoren = (int) Math.sqrt(koncTipka);

            //v kateri plasti je
            int zacPlast = (zacKoren % 2 == 0) && (zacKoren != 0) ? zacKoren - 1 : zacKoren;
            int koncPlast = (koncKoren % 2 == 0) && (koncKoren != 0) ? koncKoren - 1 : koncKoren;

            int[] xyZacPlast = izracunKoordinat(zacPlast, zacTipka);
            int[] xyKoncPlast = izracunKoordinat(koncPlast, koncTipka);

            //če je tipka 0 neki ne štima, morš poravnat na sredino
            int zacPremik = zacPlast != 0 ? size / 2 - zacPlast / 2 : size / 2 + 1;
            int koncPremik = zacPlast != 0 ? size / 2 - koncPlast / 2 : size / 2 + 1;

            int zacX = zacPremik + xyZacPlast[0];
            int koncX = koncPremik + xyKoncPlast[0];
            int zacY = zacPremik + xyZacPlast[1];
            int koncY = koncPremik + xyKoncPlast[1];

            razdalja += Math.abs(zacX - koncX) + Math.abs(zacY - koncY);
        }
        return razdalja;
    }

    /// izračuna x in y koordinate v plasti spirale
    private static int[] izracunKoordinat(int plast, int tipka) {
        int x = 0;
        int y = 0;
        int dolzinaStranice = plast + 1;
    /// mejne vrednosti v ogljiščih plasti
        int c0 = (int) Math.pow(plast, 2);
        int c1 = c0 + dolzinaStranice;
        int c2 = c1 + dolzinaStranice;
        int c3 = c2 + dolzinaStranice;

        if (tipka < c1) {
            x = tipka - c0;
        } else if (tipka < c2) {
            x = dolzinaStranice;
            y = tipka - c1;
        } else if (tipka < c3) {
            x = dolzinaStranice - (tipka - c2);
            y = dolzinaStranice;
        } else {
            y = dolzinaStranice - (tipka - c3);
        }

        return new int[]{x, y};
    }
}
