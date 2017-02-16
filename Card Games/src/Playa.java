
public class Playa extends Player{

	public Playa(String name) {
		super(name);
		
	}
	
	 /**
     * Removes and returns a legal card from the player's hand.
     */
    public Card play(Eights eights, Card prev) {
        Card card = searchBestForMatch(prev);
        if (card == null) {
            card = drawForMatch(eights, prev);
        }
        return card;
    }
    /**
     * * Searches for best match butthole
     * 
     */
    public Card searchBestForMatch(Card prev) {
        for(int a=0;a<hand.size();a++) {
        	for(int q=0;q<hand.size()-1;q++) {
        		if(hand.getCard(q).getRank()<hand.getCard(q+1).getRank()) {
        			hand.swapCards(q, q+1);
        		}
        	}
        }
    	for (int i = 0; i < hand.size(); i++) {
            Card card = hand.getCard(i);
            if (cardMatches(card, prev)) {
                return hand.popCard(i);
            }
        }
        return null;
    }
}
