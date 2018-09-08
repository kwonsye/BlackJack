import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
	public List<Card> cardDeck;//52장의 카드가 들어있는 카드덱
	public int cardDeckIndex=0;//랜덤정렬된 카드를 순서대로 뽑아주기 위한 인덱스
	
	//52장의 카드를 생성해주는 생성자
	public CardDeck() {
		
		cardDeck=new ArrayList<Card>();
	
		
		String[] patterns= {"Diamond","Club","Spade","Heart"};
		String[] types= {"A","K","Q","J","2","3","4","5","6","7","8","9","10"};
		for(String pattern:patterns) {
			for(String type:types) {
				Card card=new Card();
				card.setPattern(pattern);
				card.setType(type);
				cardDeck.add(card);
			}		
		}
		
		Collections.shuffle(cardDeck); //카드덱의 카드 랜덤정렬
	}
	
	//카드덱에서 카드를 뽑는 메소드
	public Card getCard(){
		Card card=new Card();
		card=cardDeck.get(cardDeckIndex);
		
		cardDeckIndex++;
		
		return card;
	}
	
	/*public static void main(String[] args) {
		CardDeck deck=new CardDeck();
		for(int i=0;i<deck.cardDeck.size();i++)
			System.out.println(deck.cardDeck.get(i).pattern+" "+deck.cardDeck.get(i).type);
		
		//CardDeck deck=new CardDeck();
		for(int j=0;j<2;j++) {
			Card pickedCard=new Card();
			pickedCard=deck.getCard();
			System.out.println(pickedCard.pattern+" "+pickedCard.type);
		}
	}*/
	
	
}
