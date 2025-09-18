import java.util.Scanner;
import java.util.ArrayList;
import javax.lang.model.util.ElementScanner14;

public class Run {
    public static void main(String[] args) {
        Deck deck = new Deck();

        Scanner scanner = new Scanner(System.in);
        System.out.println("How many players are there? ");
        int  playerCount = scanner.nextInt() ; 
        
        ArrayList<Player>  players =  new ArrayList<>();

        for ( int r  = 1 ; r <= playerCount;  r++ )
        {
             Scanner scanTurn = new Scanner(System.in);
             System.out.println("hit or stay?");
             String turn = scanTurn.nextLine();

             Player player  = new Player(turn);
             players.add(player);

             player.hit(deck);
             player.hit(deck);

             

        }

        for( int i = 0; i <= players.size() ; i++)
        {
            Player current = players.get(i);
            current.playTurn(deck);
            if(current.getHandValue() > 21)
            {
                System.out.println("You lost, womp womp");
                //remember to subtract monwy when you get that working

            }
            else if (current.getHandValue() == 21)
            {
                System.out.println("Bazinga you won!");
                //add their bet x1.5

            }
            else
            {
                //add to their bet
            }
        }
       // for(Card card : deck.getCards())
        //{
        //    System.out.println(card);
        //}

    }
}
