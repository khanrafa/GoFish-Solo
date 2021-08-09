//package GoFish;
//
///**
// * Models a standard (52 card deck) card. Has a suit and a value.
// *
// * @author Rafae K
// */
//
//public class StandardCard extends Card {
//
//	public enum Suit {
//		HEARTS, CLUBS, SPADES, DIAMONDS
//	}
//
//	public enum Value {
//		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
//	}
//
//	private Suit suit;
//	private Value value;
//
//	/**
//	 * Constructor that takes in a card suit and value
//	 * @param suit
//	 * @param value
//	 */
//	public StandardCard(Suit suit, Value value) {
//		this.suit = suit;
//		this.value = value;
//	}
//
//	@Override
//	public String toString() {
//		return String.format("%s of $s", suit, value);
//	}
//
//}