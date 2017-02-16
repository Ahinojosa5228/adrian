/**
 * A standard playing card.
 */
public class Card {

	public static final String[] RANKS = { null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen",
			"King" };

	public static final String[] SUITS = { "Clubs", "Diamonds", "Hearts", "Spades" };

	private final int rank;

	private final int suit;

	/**
	 * Constructs a card of the given rank and suit.
	 */
	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}

	/**
	 * Returns a negative integer if this card comes before the given card, zero
	 * if the two cards are equal, or a positive integer if this card comes
	 * after the card.
	 */
	public int compareTo(Card that) {
		if (this.suit < that.suit) {
			return -1;
		}
		if (this.suit > that.suit) {
			return 1;
		}
		if (this.rank==1&&that.rank!=1) {
			return 1;
		}
		if (that.rank==1&&this.rank!=1) {
			return -1;
		}
		if (this.rank < that.rank) {
			return -1;
		}
		if (this.rank > that.rank) {
			return 1;
		}
		return 0;
	}

	/**
	 * Returns true if the given card has the same rank AND same suit; otherwise
	 * returns false.
	 */
	public boolean equals(Card that) {
		return this.rank == that.rank && this.suit == that.suit;
	}

	/**
	 * Gets the card's rank.
	 */
	public int getRank() {
		return this.rank;
	}

	/**
	 * Gets the card's suit.
	 */
	public int getSuit() {
		return this.suit;
	}

	/**
	 * Returns the card's index in a sorted deck of 52 cards.
	 */
	public int position() {
		return this.suit * 13 + this.rank - 1;
	}

	/**
	 * Returns a string representation of the card.
	 */
	public String toString() {
		return RANKS[this.rank] + " of " + SUITS[this.suit];
	}

	public static Card[] makeDeck() {
		Card[] deck = new Card[52];
		for (int a = 0; a <= 3; a++) {
			for (int b = 1; b <= 13; b++) {
				deck[((a * 13) + b)-1] = new Card(b, a);
			}
		}
		return deck;
	}
	public static int[] suitHist(Card[] hand) {
		int clubc=0,diamondc=0,heartc=0,spadec=0;
		for(int a=0;a<hand.length;a++) {
			if (hand[a].getSuit()==0) {
				clubc++;
			}
			if(hand[a].getSuit()==1) {
				diamondc++;
			}
			if(hand[a].getSuit()==2) {
				heartc++;
			}
			if(hand[a].getSuit()==3) {
				spadec++;
			}
		}
		int hist[]=new int[4];
			hist[0]=clubc;
			hist[1]=diamondc;
			hist[2]=heartc;
			hist[3]=spadec;
		return hist;
		
	}
	public static boolean hasFlush(Card[] hand) {
		int[] hist=suitHist(hand);
		for(int a=0;a<4;a++) {
			if(hist[a]>=5) {
				return true;
			}
		}
		return false;
	}
}