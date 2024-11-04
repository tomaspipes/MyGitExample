package src;
import java.util.Scanner;

public class Player {
    
    public String name;

    public String getName(){
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String chooseHand(Scanner scanner){
        String hand = scanner.nextLine();
        while (!hand.equals(Choices.T.name()) && !hand.equals(Choices.R.name()) && !hand.equals(Choices.P.name())) {
            System.out.println("Choose between T (Tesoura), R (Pedra) or P (papel)!");
            hand = scanner.nextLine(); 
        }
        return hand;
    }
}
