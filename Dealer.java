import java.util.ArrayList;



public class Dealer extends Player
{
    private ArrayList<Card> dealerHand = new ArrayList<>();
    public Dealer()
    {
        super("Fowler");
    }

    public void dealerHit(Deck deck)
        {
            Card newCard = deck.getTopCard();
            this.dealerHand.add(newCard);
            if( dealerHand.size() == 1)
            {
                System.out.println("something's wrong with your hand...");
            }
            else{
                for(int i = 1; i<= dealerHand.size(); i++)
                {
                    System.out.println(dealerHand.get(i));
                }
            }
        }

         public int getDealertHandValue()
        {
            int totalValue = 0;
            int aceCount = 0;
            for( Card card : dealerHand)
            {
                int cardValue = card.getDealerCardValue();
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

        public void getDealerCard(Deck deck)
        {
            Card card = deck.getTopCard();

        }

}