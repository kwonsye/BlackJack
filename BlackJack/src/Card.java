
public class Card {
	public String pattern;//다이아몬드,하트,스페이드,클럽
	public String type;//A,2~10,K,Q,J
	
	public String getPattern() {
		return this.pattern;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setPattern(String pattern) {
		this.pattern=pattern;
	}

	public void setType(String type) {
		this.type=type;
	}
	
}
