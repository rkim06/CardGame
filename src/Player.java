import java.util.ArrayList;

public class Player {

    private String name;

    private ArrayList<Card> hand;
    private int points;

    public Player(String name) {
        this.name = name;
        points = 0;
    }

    public Player(String name, ArrayList<Card> hand) {
        this.name = name;
        this.hand = hand;
        points = 0;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int point){
        points += point;
    }

    public void addCard(Card cd){
        hand.add(cd);
    }

    public String printHand() {
        String hand = "";
        for (int i = 0; i < hand.size(); i++) {
            hand = hand + String.valueOf(hand.get(i))+" ");
        }
    }

    public String toString(){
        return name +" has "+ points +" points \n" +
                name + "'s cards: "printHand();
    }
}
