import java.util.Scanner;

public class PowerN {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Give me a number");
        int number = input.nextInt();
        PowerN(number, 1);
    }

    public static double PowerN(double inputNumber, double powNumber) {
        if (inputNumber == 0) {
            return 1;
        } else {
            System.out.println(Math.pow(3, powNumber));
            PowerN(inputNumber - 1, powNumber + 1);
        }
        return 0;
    }
}