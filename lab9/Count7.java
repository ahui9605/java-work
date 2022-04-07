import java.util.Scanner;

public class Count7 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = input.nextInt();
        while (number < 0) {
            number = input.nextInt();
        }
        int count = 0;
        System.out.println(count7(number, count));
    }

    public static int count7(int num, int count) {
        if (num == 0) {
            return count;
        }
        int number = num % 10;
        if (number == 7) {
            count++;
        }
        return count7(num / 10, count);
    }
}

