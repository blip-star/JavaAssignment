//find the multiples of 2,3 and 7.in a range of 71 to 150
public class DisplayMultiple {public static void main(String[] args) {
    for (int i = 71; i <= 150; i++) {
        if (i % 2 == 0 || i % 3 == 0 || i % 7 == 0) {
            System.out.println(i);
        }
    }
}
}
