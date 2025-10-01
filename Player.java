import java.util.ArrayList;
import java.util.Scanner;

public class Player
{
    private String name;
    private double money;
    private ArrayList<Card> hand = new ArrayList<>();
    private double bet;

    public Player(String name)
    {
        this.name = name;
        this.money = 100;
        this.bet = 0;
    }

    public void playTurn(Deck deck, Player player)
    {
        boolean going = true;
        while (going == true)
        {
            System.out.println(hand);
            Scanner scanner = new Scanner(System.in);
            System.out.println("hit or stay?");
            String userInput = scanner.nextLine();
            userInput.toLowerCase();

            if (userInput.equals("hit"))
            {
                this.hit(deck);
                if(this.getHandValue() > 21)
                {
                    return;
                }
            }
            else if (getHandValue() > 21)
            {
                System.out.println("You BUSTEEED, you ain't hunting no ghost so don't bust");
                break;
            }
            else{
                break;
            }
        }
    }

    public void hit(Deck deck)
    {
        Card newCard = deck.getTopCard();
        this.hand.add(newCard);
    }

    public int getHandValue()
    {
        int totalValue = 0;
        int aceCount = 0;
        for( Card card : hand)
        {
            int cardValue = card.getCardValue();
            totalValue += cardValue;
            if(cardValue == 11)
            {
                aceCount ++;
            }

        }
        while ( aceCount  > 0 && totalValue > 21)
        {
            totalValue = totalValue - 10;
            aceCount--;
        }
        return totalValue;
    }

    public void getCard(Deck deck)
    {
        Card card = deck.getTopCard();

    }

    public void setBet()
    {
        boolean validBet = false;
        while( validBet == false)
        {
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("how much do you want to bet? You have " + money +" dollars");
            Double setBetAmount = scanner2.nextDouble();
            scanner2.nextLine();
            if (setBetAmount < this.money)
            {
                setBetAmount = this.bet;
                validBet = true;
                break;
            }
            else
            {
                Scanner scanner3 = new Scanner(System.in);
                System.out.println("You bet is wrong, press enter to try again");
                scanner3.nextLine();
                validBet = false;

            }
        }


    }

    public double getMoney()
    {
       return this.money;
    }

    public String getName()
    {
        System.out.println(name);
        return name;
    }

    public String printBet()
    {
        return name + " has " + bet;
    }

    public void handleBet(int getDealerHandValue)
    {
            if(getHandValue() > 21)
            {
                System.out.println("You lost, womp womp");
                this.money = this.money - this.bet;
                

            }
            else if (getHandValue() == 21)
            {

                System.out.println("Bazinga "+ getName() + " you won!");
                System.out.println("See how fun it is to win! you should play again! and again, and again, and again...");
                this.bet = this.bet * 1.5 ;
                this.money = this.money + this.bet;

            }
            else if (getHandValue() < getDealerHandValue) 
            {

                System.out.println("You lost (major loser) :( ");
                this.money = this.money - this.bet ;
            }
            else if (getHandValue() == getDealerHandValue)
            {

                System.out.println("You tied! (loser) You don't lose or gain money");
            }

            else
            {

                System.out.println("Bazinga "+ getName() + " you won!");
                System.out.println("See how fun it is to win! you should play again! and again, and again, and again...");
                this.money = this.money + this.bet;
            }                                                                                                                      
            System.out.println("You have " + money + " money");
    }
}