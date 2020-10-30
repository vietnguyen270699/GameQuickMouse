package Model;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;



public class ItemManager {
	private ArrayList<Cake> listCake1,listCake2,listCake3;
	private ArrayList<Cat> listCat1,listCat2,listCat3;
	private int score;
	private int heart;
	private ImageIcon cakeIcon,catIcon,mouse,bang;
	public static int visitmouse_x = 250;
	public static int visitmouse_y = 500;
	public ItemManager() {
		bang = new ImageIcon("image/bang.png");
		cakeIcon = new ImageIcon("image/cake.png");
		catIcon = new ImageIcon("image/cat.png");
		mouse = new ImageIcon("image/mouse.png");
		listCake1 = new ArrayList<Cake>();
		listCake2 = new ArrayList<Cake>();
		listCake3 = new ArrayList<Cake>();
		listCat1 = new ArrayList<Cat>();
		listCat2 = new ArrayList<Cat>();
		listCat3 = new ArrayList<Cat>();
		listCat4 = new ArrayList<Cat>();
		listCat5 = new ArrayList<Cat>();
		listCat6 = new ArrayList<Cat>();	
		score = 0;
		heart = 3;

	}
	
	
	public ArrayList<Cat> getListCat1() {
		return listCat1;
	}


	public void setListCat1(ArrayList<Cat> listCat1) {
		this.listCat1 = listCat1;
	}


	public ArrayList<Cat> getListCat2() {
		return listCat2;
	}


	public void setListCat2(ArrayList<Cat> listCat2) {
		this.listCat2 = listCat2;
	}


	public ArrayList<Cat> getListCat3() {
		return listCat3;
	}


	public void setListCat3(ArrayList<Cat> listCat3) {
		this.listCat3 = listCat3;
	}


	public static  Rectangle setmouse() {
		return new Rectangle(visitmouse_x, visitmouse_y, 50, 40);
	}


	public void addCake() {
		if (Math.random() <= 0.0015) {
			listCake1.add(new Cake(125, 120, 1));
		}
		if (Math.random() <= 0.0015) {
			listCake2.add(new Cake(325, 120, 1));
		}
		if (Math.random() <= 0.0015) {
			listCake3.add(new Cake(525, 120, 1));
		}
	}
	public void addCat() {
		if (Math.random() <= 0.001) {
			listCat1.add(new Cat(125, 120, 1));
		}
		if (Math.random() <= 0.001) {
			listCat2.add(new Cat(325, 120, 1));
		}
		if (Math.random() <= 0.001) {
			listCat3.add(new Cat(525, 120, 1));
		}
	}
	

	public void down() {
		for (int i = 0; i < listCake1.size(); i++) {
			listCake1.get(i).update();
			if(listCake1.get(i).getY()>520) {
				listCake1.remove(i);
				heart--;
			}
		}
		for (int i = 0; i < listCake2.size(); i++) {
			listCake2.get(i).update();
			if(listCake2.get(i).getY()>520) {
				listCake2.remove(i);
				heart--;
			}
		}
		for (int i = 0; i < listCake3.size(); i++) {
			listCake3.get(i).update();
			if(listCake3.get(i).getY()>520) {
				listCake3.remove(i);
				heart--;
			}
		}
		for (int i = 0; i < listCat1.size(); i++) {
			listCat1.get(i).update();
		}
		for (int i = 0; i <listCat2.size(); i++) {
			listCat2.get(i).update();
		}
		for (int i = 0; i < listCat3.size(); i++) {
			listCat3.get(i).update();
		}
		collision();
	}

	public void collision() {
		for (int i = 0; i < listCake1.size(); i++) {
			if (setmouse().intersects(listCake1.get(i).shape())) {
				score++;
				listCake1.remove(i);
			}
		}
		for (int i = 0; i < listCake2.size(); i++) {
			if (setmouse().intersects(listCake2.get(i).shape())) {
				score++;
				listCake2.remove(i);
			}
		}
		for (int i = 0; i < listCake3.size(); i++) {
			if (setmouse().intersects(listCake3.get(i).shape())) {
				score++;
				listCake3.remove(i);
			}
		}
		for (int i = 0; i < listCat1.size(); i++) {
			if (setmouse().intersects(listCat1.get(i).shape())) {
				heart=0;
				listCat1.remove(i);
			}
		}
		for (int i = 0; i <listCat2.size(); i++) {
			if (setmouse().intersects(listCat2.get(i).shape())) {
				heart=0;
				listCat2.remove(i);
			}
		}
		for (int i = 0; i < listCat3.size(); i++) {
			if (setmouse().intersects(listCat3.get(i).shape())) {
				heart=0;
				listCat3.remove(i);
			}
		}
	}
	public int getScore() {
		return score;
	}
	
	public int getHeart() {
		return heart;
	}

	public void Start() {
		for (int i = 0; i < listCake1.size(); i++) {
				listCake1.remove(i);
		}
		for (int i = 0; i < listCake2.size(); i++) {
			listCake2.remove(i);
		}
		for (int i = 0; i < listCake3.size(); i++) {
			listCake3.remove(i);
		}
		heart = 3;
		score = 0;
	}
	public void paint1(Graphics g) {

		for (int i = 0; i < listCat1.size(); i++) {
			if (setmouse().intersects(listCat1.get(i).shape())) {
				g.drawImage(bang.getImage(), visitmouse_x, visitmouse_y, 70, 50, null);
			}
		}
	}

	public void paint(Graphics g) {
		//vẽ vị trí mouse
		    g.drawImage(mouse.getImage(), visitmouse_x, visitmouse_y, 70, 50, null);
		// vẽ  cake   
		  
		for (int i = 0; i < listCake1.size(); i++) {
			g.drawImage(cakeIcon.getImage(), listCake1.get(i).getX(), listCake1.get(i).getY(), 30, 30, null);
		}
		for (int i = 0; i < listCake2.size(); i++) {
			g.drawImage(cakeIcon.getImage(), listCake2.get(i).getX(), listCake2.get(i).getY(), 30, 30, null);
		}
		for (int i = 0; i < listCake3.size(); i++) {
			g.drawImage(cakeIcon.getImage(), listCake3.get(i).getX(), listCake3.get(i).getY(), 30, 30, null);
		}

		//vẽ cat
		for (int i = 0; i < listCat1.size(); i++) {
			g.drawImage(catIcon.getImage(), listCat1.get(i).getX(), listCat1.get(i).getY(), 50, 50, null);
		}
		for (int i = 0; i <listCat2.size(); i++) {
			g.drawImage(catIcon.getImage(),listCat2.get(i).getX(),listCat2.get(i).getY(), 50, 50, null);
		}
		for (int i = 0; i < listCat3.size(); i++) {
			g.drawImage(catIcon.getImage(), listCat3.get(i).getX(), listCat3.get(i).getY(), 50, 50, null);
		}
	}


}
