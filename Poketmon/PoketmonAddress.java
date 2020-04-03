package Project01;

public class PoketmonAddress {
	private int x;
	private int y;
	private String initial;
	public PoketmonAddress(int x, int y, String initial){
		this.x = x;
		this.y = y;
		this.initial = initial;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getInitial(){
		return initial;
	}
}
