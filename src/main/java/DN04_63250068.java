import java.util.Scanner;

public class DN04_63250068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] gostje = new int[n];
        int stevnik = 0;

        for (int i = 0; i < n; i++) {
            gostje[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int vsota = gostje[i] + gostje[j];
                if (vsota == k) {
                    stevnik++;
                }
            }
        }
        System.out.println(stevnik);
    }
}
