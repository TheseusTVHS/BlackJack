import java.util.ArrayList;



public class Dealer extends Player
{
    private ArrayList<Card> dealerHand = new ArrayList<>();
    public Dealer()
    {
        super("Fowler");
    }

    public void firstDealerHit(Deck deck)
        {
            Card newCard = deck.getTopCard();
            this.dealerHand.add(newCard);
            System.out.println(dealerHand);
        }

        public void SecoundDealerHit(Deck deck)
        {
            Card newCard = deck.getTopCard();
            this.dealerHand.add(newCard);
            System.out.println("The dealer is showing " + newCard) ;
        }

        public void thirdDealerHit(Deck deck)
        {
            System.out.println(dealerHand);
        }

        


         public int dealerHandValue()
        {
            int totalValue = 0;
            int aceCount = 0;
            for( Card card : dealerHand)
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

        public void getDealerCard(Deck deck)
        {
            Card card = deck.getTopCard();

        }

        public void dealerTurn(Deck deck)
        {
            while( dealerHandValue() < 17 || (dealerHandValue() == 27 && haveAces() == true))
            {
                firstDealerHit(deck);
            }
        }

        public boolean haveAces()
        {
            int totalValue = 0;
            int aceCount = 0;
            for( Card card : dealerHand)
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
                    return false;
                }
            
                else
                {
                    return true;
                }
            }
            return false;
        }
        
}