import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards;
    private int cardsLeft;

    //constructor
    public Deck(String[] ranks, String[] suits, int[] values) {
        for(int i = 0; i<ranks.length; i++){
            for(int j = 0; j<suits.length; j++){
                Card newCard = new Card(ranks[i], suits[j], values[i]);
                cards.add(newCard);
            }
        }
    }

    public boolean isEmpty(){
        if (cardsLeft == 0){
            return true;
        }
        return false;
    }

    public int getCardsLeft(){
        return cardsLeft;
    }

    public Card deal(){
        if (cardsLeft == 0){
            return null;
        }
        cardsLeft --;
        return cards.get(cardsLeft);
    }

    public void shuffle(){
        Card temp = new Card ("", "", 0);
        for(int i=0; i<cards.size(); i++){
            int r = (int)(Math.random()*cards.size())+1;

            //how to get just the value
            temp = cards.get(i);
            cards.set(i, cards.get(r));
            cards.set(r, temp);

        }
    }
}
