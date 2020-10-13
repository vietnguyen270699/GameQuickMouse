package Model;

import java.awt.Rectangle;

public abstract class Item {
	protected int x;
	protected int y;
	protected float speed;

	public Item(int x, int y, float speed) {
		this.x = x;
		this.y = y;
		this.speed = speed;
	}

	public Rectangle shape() {
		return new Rectangle(x, y, 20, 20);
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

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public void update() {
		
			y += speed+1 ;
		

	}
}
