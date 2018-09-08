import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
	public List<Card> cardDeck;//52���� ī�尡 ����ִ� ī�嵦
	public int cardDeckIndex=0;//�������ĵ� ī�带 ������� �̾��ֱ� ���� �ε���
	
	//52���� ī�带 �������ִ� ������
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
		
		Collections.shuffle(cardDeck); //ī�嵦�� ī�� ��������
	}
	
	//ī�嵦���� ī�带 �̴� �޼ҵ�
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
