import java.util.ArrayList;
import java.util.List;

public class Dealer implements Player{
	//딜러가 뽑은 카드리스트
	List<Card> dealerCards;
	
	//생성자
	public Dealer() {
		dealerCards=new ArrayList<Card>();
	}
	
	public void getCard(Card card) {
		Card pickedCard=new Card();
		pickedCard=card;
		
		dealerCards.add(pickedCard);
	}
	
	public void showCard() {
		System.out.println("현재 보유 카드");
		for(int i=0;i<dealerCards.size();i++)
			System.out.println(dealerCards.get(i).pattern+" "+dealerCards.get(i).type);
	}
	
	/*
	public static void main(String[] args) {
		Dealer dealer=new Dealer();
		
		CardDeck deck=new CardDeck();
		Card pickedCard=new Card();
		pickedCard=deck.getCard();
		
		dealer.getCard(pickedCard);
		System.out.println(dealer.dealerCards.get(0).pattern+" "+dealer.dealerCards.get(0).type);
	}*/
	
}
