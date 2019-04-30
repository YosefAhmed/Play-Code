package forms;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class Movement implements MouseListener, MouseMotionListener{

	public int x,y;
	
/*	public Movement(Component... pns) {
		for(Component panel : pns) {
			panel.addMouseListener(this);
			panel.addMouseMotionListener(this);
		}
	}*/

	public Movement() {
	}
	
	boolean draged,pressed;

	public void tick() {
	 	System.out.println(draged+"  "+ pressed);

	}
	
	@Override
	public void mouseDragged(MouseEvent e) {

		e.getComponent().setLocation((e.getX()+e.getComponent().getX())-x,(e.getY()+e.getComponent().getY())-y);
		//System.out.println(e.getComponent().getX()+"  "+e.getComponent().getY());

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//System.out.println(e.getButton());
		pressed=true;
		x=e.getX();
		y=e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		pressed=false;
	}

}
