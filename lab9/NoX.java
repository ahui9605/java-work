import java.util.Scanner;

public class NoX {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your text: ");
        String text = input.nextLine();
        System.out.println(noX(text, 'x'));
    }

    public static String noX(String input, char letter) {
        if (input.length() == 0) {
            return input;
        } else {
            if (input.charAt(0) == letter) {
                return noX(input.substring(1), letter);
            } else {
                return input.charAt(0) + noX(input.substring(1), letter);
            }
        }
    }
}
//
//    String newabc = "";
//        for (int i = 0; i < input.length(); i++) {
//        String f = input.substring(i, i + 1);
//        String I = "x";
//
//        if (!(f.equals(I))) {
//        newabc = newabc + input.substring(i, i + 1);
//        }
//        }