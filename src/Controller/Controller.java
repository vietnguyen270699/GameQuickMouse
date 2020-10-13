package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import Model.ItemManager;
import View.GamePanel;

public class Controller implements MouseMotionListener {

	ItemManager itemmouse;

	public Controller(ItemManager itemmouse) {
		this.itemmouse = itemmouse;
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	//	itemmouse.visitmouse_x = e.getX();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		itemmouse.visitmouse_x = e.getX();
	}
}
