import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> hand;
    private int points;

    //constructor sets points to zero and initializes name
    public Player(String name) {
        this.name = name;
        points = 0;
    }

    //constructor sets points to zero and initializes name AND hand
    public Player(String name, ArrayList<Card> hand) {
        this.name = name;
        this.hand = hand;
        points = 0;
    }

    //returns name
    public String getName() {
        return name;
    }

    //returns name
    public ArrayList<Card> getHand() {
        return hand;
    }

    //returns num of points
    public int getPoints() {
        return points;
    }

    //adds given number of points to the existing points
    public void addPoints(int point){
        points += point;
    }

    //adds a card to the hand
    public void addCard(Card cd){
        hand.add(cd);
    }

    public String toString(){
        return name +" has "+ points +" points \n" +
                name + "'s cards: "+hand;
    }

}
