import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards;
    private int cardsLeft;

    //constructor
    public Deck(String[] ranks, String[] suits, int[] values) {
        //declare new arraylist of cards
        cards = new ArrayList<Card>();
        cardsLeft = 52;

        //creates a new card with a rank, suit, and value
        //from the arrays passed in as parameters
        for(int i = 0; i<ranks.length; i++){
            for(int j = 0; j<suits.length; j++){
                Card newCard = new Card(ranks[i], suits[j], values[i]);
                //adds the new card to an arraylist of cards (named cards)
                cards.add(newCard);
            }
        }
    }

    //if there are no cards left, return true
    public boolean isEmpty(){
        if (cardsLeft == 0){
            return true;
        }
        return false;
    }

    //returns the number of cards left
    public int getCardsLeft(){
        return cardsLeft;
    }

    //deals a card from the cards arraylist
    //if there are no cards left return null
    //or else return a card at cardsLeft
    //(this will start at the end and make its way towards zero)
    public Card deal(){
        if (cardsLeft == 0){
            return null;
        }
        //ensures that the same card is not being dealt
        cardsLeft --;
        return cards.get(cardsLeft);
    }

    //shuffles cards by switching random cards in "cards"
    public void shuffle(){
        //creates a temporary card that has no actual values (since its like a placeholder)
        Card temp = new Card ("", "", 0);
        for(int i=0; i<cards.size(); i++){
            //generates a random integer between 0 and i
            int r = (int)(Math.random()*i);

            //uses the temporary value to hold the value of cards.get(i)
            //which allows cards.get(i) to switch values with cards.get(r)
            temp = cards.get(i);
            cards.set(i, cards.get(r));
            cards.set(r, temp);
        }
    }
}
