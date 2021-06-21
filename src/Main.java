import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        input = input.trim()
                .replaceAll("\\n+", "")
                .replaceAll("\\t+", " ")
                .replaceAll("\\s+", "");

        int numberOfTurns = 0;
        String[] combinations = new String[2];
        combinations = input.split(",");

        if (combinations.length > 2) {
            throw new IllegalArgumentException();
        }

        int[][] intCombinations = new int[2][3];
        for (int i = 0; i < combinations.length; i++) {
            if (combinations[i].length() != 3) {
                throw new IllegalArgumentException();
            }
        }
        for (int i = 0; i < combinations.length; i++) {
            for (int j = 0; j < combinations[i].length(); j++) {
                intCombinations[i][j] = Integer.valueOf(Character.toString(combinations[i].charAt(j)));
            }
        }
        for (int j = 0; j < intCombinations[0].length; j++) {
            int temp1 = Math.abs(intCombinations[0][j] - intCombinations[1][j]);
            if (temp1 < (10 - temp1)) {
                numberOfTurns += temp1;
            } else {
                numberOfTurns = numberOfTurns + 10 - temp1;
            }
        }
        System.out.println(numberOfTurns);
    }
}
