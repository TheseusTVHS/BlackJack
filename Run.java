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
             System.out.println("What is your name player " + r);
             String playerName = scanTurn.nextLine();

             Player player  = new Player(playerName);
             players.add(player);

        }
        Dealer dealerFowler = new Dealer();
        boolean gameGoing = true;
        while (gameGoing)
        { 

            for( Player player: players)
            {
                player.setBet();
                player.getDeal(deck);
            }
            dealerFowler.getDealer(deck);

            for( Player player : players)
            {
                player.playTurn(deck ,player);
                player.handleBet(dealerFowler.dealerHandValue());
                if(player.getMoney() == 0.00)
                {
                    System.out.println("You're out of money :( , don't bet so much next time");
                    gameGoing = false;
                }
                else{
                    Scanner scan = new Scanner(System.in);
                    System.out.println("Do you want to continue playing?");
                    String playerChoice = scan.nextLine();
                    if ( playerChoice.equals("yes"))
                    {
                        gameGoing = true;
                    }
                    else
                    {
                        gameGoing = false;
                    }
                }
            }
        }
        dealerFowler.dealerTurn(deck);

    }
}
