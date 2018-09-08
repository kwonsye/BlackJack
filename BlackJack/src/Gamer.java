import java.util.ArrayList;
import java.util.List;

public class Gamer implements Player{
	//게이머가 뽑은 카드리스트
	List<Card> gamerCards;
	
	// 생성자
	public Gamer() {
		gamerCards=new ArrayList<Card>();
	}
		
	public void getCard(Card card) {
		Card pickedCard=new Card();
		pickedCard=card;
			
		gamerCards.add(pickedCard);
	}
		
	public void showCard() {
		System.out.println("현재 보유 카드");
		for(int i=0;i<gamerCards.size();i++)
			System.out.println(gamerCards.get(i).pattern+" "+gamerCards.get(i).type);
	}
}
