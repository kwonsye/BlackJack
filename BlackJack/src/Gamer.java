import java.util.ArrayList;
import java.util.List;

public class Gamer implements Player{
	//���̸Ӱ� ���� ī�帮��Ʈ
	List<Card> gamerCards;
	
	// ������
	public Gamer() {
		gamerCards=new ArrayList<Card>();
	}
		
	public void getCard(Card card) {
		Card pickedCard=new Card();
		pickedCard=card;
			
		gamerCards.add(pickedCard);
	}
		
	public void showCard() {
		System.out.println("���� ���� ī��");
		for(int i=0;i<gamerCards.size();i++)
			System.out.println(gamerCards.get(i).pattern+" "+gamerCards.get(i).type);
	}
}
