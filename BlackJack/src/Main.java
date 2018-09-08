import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("===========BlackJack ������ �����մϴ�=============");
		
		Dealer dealer=new Dealer();
		Gamer gamer=new Gamer();
		CardDeck deck=new CardDeck();
		Rule rule=new Rule();
		
		int dealerScore=0,gamerScore=0;
		
		//���徿 �̴� ù��° ��
		System.out.println("ó�� �� �徿 ī�带 �̰ڽ��ϴ�.");
		int firstTurn=0;
		while(firstTurn<2) {
			
			System.out.println("Dealer�� �����Դϴ�.");
			
			//ī��̾Ƽ� �������� �ֱ�
			dealer.getCard(deck.getCard());
			
			//������ ī���Ϻ����ֱ�
			dealer.showCard();
			
			System.out.println("");
			
			
			System.out.println("Gamer�� �����Դϴ�.");
			
			//ī��̾Ƽ� ���̸ӿ��� �ֱ�
			gamer.getCard(deck.getCard());
			
			//���̸��� ī���Ϻ����ֱ�
			gamer.showCard();
			
			System.out.println("");
			
			firstTurn++;
		
		}
		
		
		//ù��° ���� ���� �� �ؾ��� �ϵ�!
		boolean dealerIsStop=false; //true=������ �������� false=�������� �ʾ���
		boolean gamerIsStop=false;
		
		//���� �Ѹ��̶� ������ �������� �ʾҴٸ�
		while(dealerIsStop==false||gamerIsStop==false) {
			
			System.out.println("Dealer�� �����Դϴ�.");
			
			//���� ���������ͼ�
			dealerScore=rule.getScore(dealer);
			if(dealerScore>=17)
			{
				System.out.println("���̻� ������ �� �����ϴ�.");
				dealerIsStop=true; //������ ��������
				
				System.out.println("");
			}
			else if(dealerScore<=16)
			{
				System.out.print("ī�带 �ݵ�� �����ž� �մϴ�.Yes�� �Է��Ͻø� ī�带 �̰ڽ��ϴ� :");
				String answer=sc.next();
				if(answer.equals("Yes")) {
					//ī��̾Ƽ� �������� �ֱ�
					dealer.getCard(deck.getCard());
				
					//������ ī���Ϻ����ֱ�
					dealer.showCard();
				
					System.out.println("");
				}
				
				//else
					//System.out.println("�ٽ� �Է��ϼ���.");
			
			}
			
			
			System.out.println("Gamer�� �����Դϴ�.");
			
			//���̸Ӱ� �̹� ������ ������ ���¶��
			if(gamerIsStop==true) {
				System.out.println("���̻� ������ �� �����ϴ�.");
				System.out.println("");
			}
			//������ ������ ���°� �ƴ϶��
			else if(gamerIsStop==false) {
			
				System.out.print("ī�带 �����ðڽ��ϱ�?(Yes/No) No�� �Է��ϸ� ������ ����˴ϴ� :");
				String answer=sc.next();
				//Y �Է��ϸ�
				if(answer.equals("Yes")) {
					//ī��̾Ƽ� ���̸ӿ��� �ֱ�
					gamer.getCard(deck.getCard());
		
					//���̸��� ī���Ϻ����ֱ�
					gamer.showCard();
			
					System.out.println("");
				}
			
				//N �Է��ϸ�
				else if(answer.equals("No")) {
					gamerIsStop=true; //���̸� ��������
					System.out.println("");
				}
			}
			
			
		}
		
		//������ ���̸Ӱ� �Ѵ� ������ �����ߴٸ� ī�� ���� ����
		if((dealerIsStop==true)&&(gamerIsStop==true)) {
			
			//���� ������ �ͼ�
			dealerScore=rule.getScore(dealer);
			gamerScore=rule.getScore(gamer);
			//���� �̰���� ���
			rule.getWinner(dealerScore, gamerScore);
		}
		
		
		sc.close();
	}
	
}
