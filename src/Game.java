import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Player p1;
    private Player p2;
    private Deck deck;

    private static final String[] SUITS = {"clubs", "hearts", "diamonds", "spades"};
    private static final String[] RANKS = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K",};
    private static final int[] VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

    //constructor that initializes both players
    //and a deck of cards
    public Game() {
        Scanner input = new Scanner(System.in);
        System.out.print("Input Player1's name: ");
        String p1Name = input.nextLine();
        System.out.print("Input Player2's name: ");
        String p2Name = input.nextLine();

        p1 = new Player(p1Name);
        p2 = new Player(p2Name);

        deck = new Deck(RANKS, SUITS, VALUES);
    }

    public void printInstructions(){
        System.out.println("\nWelcome to Battle: a game very much about chance. \n"
                +"The rules are simple. Each player puts down a card. Whoever has the higher card gets a point."
                +"If the cards are the same, each player puts down another card.\n Whoever ends up with the most cards wins!!!\n\n" +
                "Press enter when you are ready to start.");
    }

    public void playGame() {
        Scanner input = new Scanner(System.in);
        //basic necessities in a card game: shuffling the deck and giving instructions
        deck.shuffle();
        printInstructions();
        input.nextLine();

        //creates empty hands for player1 and player2
        ArrayList<Card> handP1 = new  ArrayList<Card>();
        ArrayList<Card> handP2 = new  ArrayList<Card>();

        //deals a hand for player1 and player2
        for(int i=0; i<6; i++){
            //first 5 cards dealt are for player1
            if(i<3){
                handP1.add(deck.deal());
            }
            //last 5 cards dealt are for player2
            else{
                handP2.add(deck.deal());
            }
        }

        //gives each player their hand
        p1 = new Player(p1.getName(), handP1);
        p2 = new Player(p2.getName(), handP2);

        for(int i=0; i<3; i++){
            System.out.println("\n\nRound "+(i+1)+":");

            //deal one card from each player's hand
            //and print the card that the player put down
            System.out.println();
            Card card1 = handP1.remove(0);
            System.out.println(p1.toString());
            Card card2 = handP2.remove(0);
            System.out.println(p2.toString());
            //compare the two cards for greater value
            int points1 = card1.getPoint();
            int points2 = card2.getPoint();
            if(points1 > points2){
                p1.addPoints(1);
            }
            else if(points1 < points2){
                p2.addPoints(1);
            }
            else{
                //if cards are equal call tieBreak
                tieBreak(card1, card2);
            }
        }

        //after three rounds, compare the number of points per player
        //call printWinner to print the winner
        printWinner(p1, p2);
    }

    //if there is a tie, place another card down
    public void tieBreak(Card card1, Card card2){
        int points1 = card1.getPoint();
        int points2 = card2.getPoint();

        //add a point to the player that wins the round
        if(points1 > points2){
            p1.addPoints(1);
        }
        else if(points1 < points2){
            p2.addPoints(1);
        }
        //or else place another card
        else{
            tieBreak(card1, card2);
        }
    }

    //prints the winner of the game based on the number of points
    public void printWinner(Player p1, Player p2){
        System.out.println(p1.getName()+": "+p1.getPoints());
        System.out.println(p2.getName()+": "+p2.getPoints());
        System.out.println();

        //the player with the most points wins
        if (p1.getPoints() > p2.getPoints()){
            System.out.println(p1.getName()+" won the game!!!");
        }
        else if (p1.getPoints() < p2.getPoints()){
            System.out.println(p1.getName()+" won the game!!!");
        }
        //if points are equal, no one wins
        else{
            System.out.println("No one won the game :(");
        }
    }

    //main method creates a new instance of a game to play
    public static void main(String[] args) {
        Game g = new Game();
        g.playGame();
    }
}
