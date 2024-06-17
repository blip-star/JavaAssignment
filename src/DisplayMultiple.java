public class DisplayMultiple {public static void main(String[] args) {
    for (int i = 71; i <= 150; i++) {
        if (i % 2 == 0 || i % 3 == 0 || i % 7 == 0) {
            System.out.println(i);
        }
    }
}
}
