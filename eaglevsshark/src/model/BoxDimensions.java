package model;

/*Defines all the dimensions of Boxes 
present in Board and also 
contains boxNo*/

public class BoxDimensions {
	
	private int x;
	private int y;
	private int boxDimension;
	private int boxNo;
	
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
	public int getBoxNo() {
		return boxNo;
	}
	public void setBoxNo(int boxNo) {
		this.boxNo = boxNo;
	}
	public int getBoxDimension() {
		return boxDimension;
	}
	public void setBoxDimension(int boxDimension) {
		this.boxDimension = boxDimension;
	}
	

}
