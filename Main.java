import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Do you want to encode or decode?");
        String operation = input.nextLine();

        if (operation.equals("encode")||operation.equals("Encode")) {
            System.out.println("What is the original message?");
            String message = input.nextLine();

            System.out.println("Enter the shift amount: ");
            int shift = input.nextInt();

            String encodedMessage = encode(message, shift);
            System.out.println("Encoded message: " + encodedMessage);

        } 
        if (operation.equals("decode")||operation.equals("Decode")) 
        {
            System.out.println("What is the original message?");
            String message = input.nextLine();

            System.out.println("Possible options:");
            bruteForceDecode(message);

        }
    }

    public static String encode(String message, int shift) {
        StringBuilder result = new StringBuilder();

      int count=0;
        while (count < message.length()) {
            char char1 = message.charAt(count);

            if (Character.isLetter(char1)) {
                char char2 = (char) ((char1 - 'a' + shift) % 26 + 'a');
                result.append(char2);
            } else {
                result.append(char1);
            }
          count++;
        }

        return result.toString();
    }

    private static void bruteForceDecode(String message) {
      int count=0;
        while (count < 26) {
            String decodedMessage = decode(message, count);
            System.out.println("Shift: " + count + "\tMessage: " + decodedMessage);
          count++;
        }
    }

    private static String decode(String message, int count) {
        return encode(message, 26 - (count % 26)); 
    }
}