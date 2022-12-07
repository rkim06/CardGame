public class Player {

    private String name;
    private int[] cards;
    private int[] hand;
    private int points;

    public Player(String name) {
        this.name = name;
        points = 0;
    }

    public Player(String name, int[] hand) {
        this.name = name;
        this.hand = hand;
        points = 0;
    }

    public String getName() {
        return name;
    }

    public int[] getCards() {
        return cards;
    }

    public int[] getHand() {
        return hand;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(){

    }

    public void addCard(){

    }

    public String toString(){
        return rank +" of "+ suit;
    }
}
