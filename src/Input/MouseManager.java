package Input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
public class MouseManager implements MouseListener, MouseMotionListener{

		public int x,y,state=0;
		public boolean pressed;

		public void tick() {			
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			x=e.getX();
			y=e.getY();
			System.out.println(e.getX()+"  "+e.getY());
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public int pressDown=0;
		@Override
		public void mousePressed(MouseEvent e) {
			
		    if (e.getButton() == MouseEvent.BUTTON1) {
		    	pressDown++;
		    }
		    if(pressDown==2) {
		    	pressed=true;

		    }
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			pressed=false;
		}

	

}
