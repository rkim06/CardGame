public class Card {
    private String rank;
    private String suit;
    private int point;

    public Card(String rank, String suit, int point) {
        this.rank = rank;
        this.suit = suit;
        this.point = point;
    }
    //returns rank of card
    public String getRank() {
        return rank;
    }

    //returns suit of card
    public String getSuit() {
        return suit;
    }

    //returns num of points
    public int getPoint() {
        return point;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String toString(){
        return rank +" of "+ suit;
    }
}
