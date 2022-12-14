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
        System.out.println("Welcome to War (pg ver): a game very much about chance. \n"
                +"The rules are simple. Each player puts down a card. Whoever has the higher card gets to keep both cards."
                +"If the cards are the same, no one keeps them.\n Whoever ends up with the most cards wins!!!\n\n" +
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
        for(int i=0; i<10; i++){
            //first 5 cards dealt are for player1
            if(i<5){
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



    }

    public static void main(String[] args) {
        Game g = new Game();
        g.playGame();
    }
}
