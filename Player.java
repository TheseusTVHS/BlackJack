import java.util.ArrayList;
import java.util.Scanner;
import javax.lang.model.util.ElementScanner14;

public class Player
{
    private String name;
    private double money;
    private ArrayList<Card> hand = new ArrayList<>();

    public Player(String name)
    {
        this.name = name;
        this.money = 100;
    }

    public void playTurn()
    {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
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
        while ( aceCount  > 0)
        {
            if (totalValue > 21)
            {
                totalValue = totalValue - 10;
            }
        }
        if(aceCount > 0 && totalValue > 21)
            {
                totalValue = totalValue - 10;
            }
        else
        {
            aceCount = 0;
        }
        return totalValue;
    }

    public void getCard(Deck deck)
    {
        Card card = deck.getTopCard();

    }
}