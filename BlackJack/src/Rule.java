import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rule {
	//카드의 타입별 점수가 각각 매핑되어 있는 변수
	Map<String,Integer> scoreMap;
	
	//생성자에서 점수테이블 만들어놓음
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
			
			//점수표불러와서 점수계산하기
			for(int i=0;i<dealerCards.size();i++) {
				String key=dealerCards.get(i).type;
				score+=(scoreMap.get(key));
			}
		}
		
		if(playerType.equals("Gamer")) {
			List<Card> gamerCards=((Gamer)player).gamerCards;
			
			//점수표불러와서 점수계산하기
			for(int i=0;i<gamerCards.size();i++) {
				String key=gamerCards.get(i).type;
				score+=scoreMap.get(key);
			}
		}
		
		//플레이어의 점수 반환
		return score;
		
		
		
	} 
	
	//승패판단
	public void getWinner(int dealerScore,int gamerScore) {
		
		//21점 초과하면 무조건 진다.
		if(dealerScore>21&&gamerScore<=21)
			System.out.println("게이머가 이겼습니다.");
		if(gamerScore>21&&dealerScore<=21)
			System.out.println("딜러가 이겼습니다.");
		if(gamerScore>21&&dealerScore>21)
			System.out.println("비겼습니다.");
		
		
		
		//21점에 가까운사람이 이긴다.
		else if(dealerScore<=21&&gamerScore<=21) {
			int absDealerScore=Math.abs(21-dealerScore);
			int absGamerScore=Math.abs(21-gamerScore);
			
			if(absDealerScore<absGamerScore) {
				System.out.println("딜러가 이겼습니다.");
			}
			if(absDealerScore>absGamerScore) {
				System.out.println("게이머가 이겼습니다.");
			}
			if(absDealerScore==absGamerScore) {
				System.out.println("비겼습니다.");
			}
		}
	
			
	}
	
}
