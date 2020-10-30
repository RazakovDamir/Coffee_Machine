import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        int max = 1;
        int max2 = 1;

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = n - 1; i > 0; i--) {
            if (array[i] > array[i - 1]) {
                max++;
            } else {
                if (max > max2) {
                    max2 = max;
                    max = 0;
                }
            }
        }
        System.out.println(Math.max(max, max2));
    }
}