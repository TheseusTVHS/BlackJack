import java.util.ArrayList;
import java.util.Scanner;

public class Run 
{
    public static void main(String[] args) {
        Deck deck = new Deck();

        Scanner scanner = new Scanner(System.in);
        System.out.println("How many players are there? ");
        int  playerCount = scanner.nextInt() ; 



        
        ArrayList<Player>  players =  new ArrayList<>();

        for ( int r  = 1 ; r <= playerCount;  r++ )
        {
             Scanner scanTurn = new Scanner(System.in);
             System.out.println("What are your names?");
             String turn = scanTurn.nextLine();

             Player player  = new Player(turn);
             players.add(player);

        }
        Dealer dealerFowler = new Dealer();
        boolean gameGoing = true;
        while (gameGoing  = true)
        { 
            for( Player player: players)
            {
                player.setBet();
                player.hit(deck);
                player.hit(deck);
            }
            dealerFowler.firstDealerHit(deck);
            dealerFowler.SecoundDealerHit(deck);
        
            dealerFowler.dealerTurn(deck);
            for( Player player : players)
            {
                player.playTurn(deck ,player);
                if(player.getMoney() == 0.00)
                {
                    gameGoing = false;
                }
                else{
                    Scanner scan = new Scanner(System.in);
                    System.out.println("Do you wnat ot continue playing?");
                    String playerChoice = scan.nextLine();
                    if ( playerChoice.equals("yes"))
                    {
                    gameGoing = false;
                    }
                }
            }
        }
        dealerFowler.dealerTurn(deck);

    }
}
