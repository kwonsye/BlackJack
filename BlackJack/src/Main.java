import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("===========BlackJack 게임을 시작합니다=============");
		
		Dealer dealer=new Dealer();
		Gamer gamer=new Gamer();
		CardDeck deck=new CardDeck();
		Rule rule=new Rule();
		
		int dealerScore=0,gamerScore=0;
		
		//두장씩 뽑는 첫번째 턴
		System.out.println("처음 두 장씩 카드를 뽑겠습니다.");
		int firstTurn=0;
		while(firstTurn<2) {
			
			System.out.println("Dealer의 차례입니다.");
			
			//카드뽑아서 딜러에게 주기
			dealer.getCard(deck.getCard());
			
			//딜러의 카드목록보여주기
			dealer.showCard();
			
			System.out.println("");
			
			
			System.out.println("Gamer의 차례입니다.");
			
			//카드뽑아서 게이머에게 주기
			gamer.getCard(deck.getCard());
			
			//게이머의 카드목록보여주기
			gamer.showCard();
			
			System.out.println("");
			
			firstTurn++;
		
		}
		
		
		//첫번째 턴이 끝난 후 해야할 일들!
		boolean dealerIsStop=false; //true=게임을 종료했음 false=종료하지 않았음
		boolean gamerIsStop=false;
		
		//둘중 한명이라도 게임을 종료하지 않았다면
		while(dealerIsStop==false||gamerIsStop==false) {
			
			System.out.println("Dealer의 차례입니다.");
			
			//딜러 점수가져와서
			dealerScore=rule.getScore(dealer);
			if(dealerScore>=17)
			{
				System.out.println("더이상 뽑으실 수 없습니다.");
				dealerIsStop=true; //딜러는 게임종료
				
				System.out.println("");
			}
			else if(dealerScore<=16)
			{
				System.out.print("카드를 반드시 뽑으셔야 합니다.Yes를 입력하시면 카드를 뽑겠습니다 :");
				String answer=sc.next();
				if(answer.equals("Yes")) {
					//카드뽑아서 딜러에게 주기
					dealer.getCard(deck.getCard());
				
					//딜러의 카드목록보여주기
					dealer.showCard();
				
					System.out.println("");
				}
				
				//else
					//System.out.println("다시 입력하세요.");
			
			}
			
			
			System.out.println("Gamer의 차례입니다.");
			
			//게이머가 이미 게임을 종료한 상태라면
			if(gamerIsStop==true) {
				System.out.println("더이상 뽑으실 수 없습니다.");
				System.out.println("");
			}
			//게임을 종료한 상태가 아니라면
			else if(gamerIsStop==false) {
			
				System.out.print("카드를 뽑으시겠습니까?(Yes/No) No를 입력하면 게임이 종료됩니다 :");
				String answer=sc.next();
				//Y 입력하면
				if(answer.equals("Yes")) {
					//카드뽑아서 게이머에게 주기
					gamer.getCard(deck.getCard());
		
					//게이머의 카드목록보여주기
					gamer.showCard();
			
					System.out.println("");
				}
			
				//N 입력하면
				else if(answer.equals("No")) {
					gamerIsStop=true; //게이머 게임종료
					System.out.println("");
				}
			}
			
			
		}
		
		//딜러와 게이머가 둘다 게임을 종료했다면 카드 점수 오픈
		if((dealerIsStop==true)&&(gamerIsStop==true)) {
			
			//점수 가지고 와서
			dealerScore=rule.getScore(dealer);
			gamerScore=rule.getScore(gamer);
			//누가 이겼는지 출력
			rule.getWinner(dealerScore, gamerScore);
		}
		
		
		sc.close();
	}
	
}
