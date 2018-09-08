import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rule {
	//ī���� Ÿ�Ժ� ������ ���� ���εǾ� �ִ� ����
	Map<String,Integer> scoreMap;
	
	//�����ڿ��� �������̺� ��������
	public Rule() {
		scoreMap=new HashMap<String,Integer>();
		
		for(int i=2;i<=10;i++) {
			scoreMap.put(Integer.toString(i), i);
		}
		
		scoreMap.put("K", 10);
		scoreMap.put("Q", 10);
		scoreMap.put("J", 10);
		scoreMap.put("A", 1);
		
	}
	
	
	
	
	public int getScore(Object player) {
		int score=0;
		
		String playerType=player.getClass().getName();
		
		if(playerType.equals("Dealer")) {
			List<Card> dealerCards=((Dealer)player).dealerCards;
			
			//����ǥ�ҷ��ͼ� ��������ϱ�
			for(int i=0;i<dealerCards.size();i++) {
				String key=dealerCards.get(i).type;
				score+=(scoreMap.get(key));
			}
		}
		
		if(playerType.equals("Gamer")) {
			List<Card> gamerCards=((Gamer)player).gamerCards;
			
			//����ǥ�ҷ��ͼ� ��������ϱ�
			for(int i=0;i<gamerCards.size();i++) {
				String key=gamerCards.get(i).type;
				score+=scoreMap.get(key);
			}
		}
		
		//�÷��̾��� ���� ��ȯ
		return score;
		
		
		
	} 
	
	//�����Ǵ�
	public void getWinner(int dealerScore,int gamerScore) {
		
		//21�� �ʰ��ϸ� ������ ����.
		if(dealerScore>21&&gamerScore<=21)
			System.out.println("���̸Ӱ� �̰���ϴ�.");
		if(gamerScore>21&&dealerScore<=21)
			System.out.println("������ �̰���ϴ�.");
		if(gamerScore>21&&dealerScore>21)
			System.out.println("�����ϴ�.");
		
		
		
		//21���� ��������� �̱��.
		else if(dealerScore<=21&&gamerScore<=21) {
			int absDealerScore=Math.abs(21-dealerScore);
			int absGamerScore=Math.abs(21-gamerScore);
			
			if(absDealerScore<absGamerScore) {
				System.out.println("������ �̰���ϴ�.");
			}
			if(absDealerScore>absGamerScore) {
				System.out.println("���̸Ӱ� �̰���ϴ�.");
			}
			if(absDealerScore==absGamerScore) {
				System.out.println("�����ϴ�.");
			}
		}
	
			
	}
	
}
