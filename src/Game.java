import java.util.Scanner;

public class Game {
    private Player p1;
    private Player p2;
    private Deck deck;

    private static final String[] SUITS = {"clubs", "hearts", "diamonds", "spades"};
    private static final String[] RANKS = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K",};
    private static final int[] VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};


    public Game(Player p1, Player p2, Deck deck) {
        this.p1 = p1;
        this.p2 = p2;
        this.deck = deck;
    }

    public void printInstructions(){
        System.out.println("Welcome to War (pg ver): a game very much about chance. \n"
                +"The rules are simple. Each player puts down a card. Whoever has the higher card gets to keep both cards."
                +"If the cards are the same, no one keeps them.\n Whoever ends up with the most cards wins!!!\n\n");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Input Player1's name: ");
        String p1Name = input.nextLine();
        input.nextLine();
        System.out.print("Input Player2's name: ");
        String p2Name = input.nextLine();

        Deck deck = new Deck(RANKS, SUITS, VALUES);

        Player p1 = new Player(p1Name);
        Player p2 = new Player(p2Name);

        Game game = new Game();
    }
}
