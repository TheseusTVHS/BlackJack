import java.util.ArrayList;
import java.util.Scanner;

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

        }


        for( int i = 0; i <= players.size() ; i++)
        {
            Player current = players.get(i);
           handleBet(getDealerHandValue);
            
        }
       // for(Card card : deck.getCards())
        //{
        //    System.out.println(card);
        //}

    }
}
