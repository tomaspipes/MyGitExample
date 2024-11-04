package src;
import java.util.Scanner;

public class Game {

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        Player player = new Player();
        player.setName(name);

        System.out.println("Hello " + player.getName() + "!\nHow many times would you like to play?");
        int numberOfRounds = scanner.nextInt();
        gameLogic(player, numberOfRounds, scanner);
    }

    public void gameLogic(Player player, int numberOfRounds, Scanner scanner) {
        int roundsWon = 0;

        int finalRounds = numberOfRounds;
        while (numberOfRounds > 0) {
            String playerHand = player.chooseHand(scanner);
            String computerHand = Choices.getRandomValue().name();
            String result = determineOutcome(playerHand, computerHand);

            switch (result) {
                case "won":
                    System.out.println(playerHand + "-" + computerHand + "\n" + player.getName() + " won the round!");
                    roundsWon++;
                    break;
                case "lost":
                    System.out.println(playerHand + "-" + computerHand + "\n" + player.getName() + " lost the round!");
                    break;
                case "drew":
                    System.out.println(playerHand + "-" + computerHand + "\n" + player.getName() + " drew the round!");
                    break;
                default:
                    throw new IllegalArgumentException("Invalid outcome");
            }
            numberOfRounds--;
        }

        System.out.println("Game over! " + player.getName() + " won " + roundsWon + " rounds" + " out of " + (finalRounds) + " rounds played.");
    }

    private String determineOutcome(String playerHand, String computerHand) {
        if (playerHand.equals(computerHand)) {
            return "drew";
        }
        switch (playerHand) {
            case "R":
                return computerHand.equals(Choices.T.name()) ? "won" : "lost";
            case "T":
                return computerHand.equals(Choices.P.name()) ? "won" : "lost";
            case "P":
                return computerHand.equals(Choices.R.name()) ? "won" : "lost";
            default:
                throw new IllegalArgumentException("Invalid player hand");
        }
    }
}

