package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import static helpers.Artist.*;
import static org.lwjgl.opengl.GL11.glOrtho;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

public class UI {
	
	private ArrayList<Button> buttonList;

	
	// public static boolean scrollingEnabled = false;
	// public static int cameraHeight = 1;
	
	public UI(){
		buttonList = new ArrayList<>();
	}
	
	public void addButton(String name, Texture texture, int x, int y){
		buttonList.add(new Button(name, texture,x,y));
	}
	
	public boolean isButtonClicked(String buttonName){
		Button b = getButton(buttonName);
		float mouseY = HEIGHT - Mouse.getY()-1;
		//ist der Zeiger auf dem Button?
		if(Mouse.getX() > b.getX() && Mouse.getX() < b.getX() + b.getWidth()  && mouseY > b.getY()&& mouseY < b.getY() + b.getHeight()){
//			while(mouseListener.mouseLeftButtonPressed){
//				try {
//					Thread.sleep(50);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
			return true;
		}
		return false;
	}
	
	private Button getButton(String buttonName){
		for(Button b: buttonList){
			if(b.getName().equals(buttonName)){
				return b;
			}
		}
		return null;
	}
	
	public void draw(){
		for(Button b : buttonList){
			drawQuadTex(b.getTexture(),b.getX(),b.getY(),b.getWidth(),b.getHeight(),0);
		}
	}
	

/*	
	public static void checkMouseWheel() {
	    	int dWheel = Mouse.getDWheel();
	    	if (dWheel < 0) {
	    		System.out.println("DOWN");
	    	} 
	    	else if (dWheel > 0){
	    		System.out.println("UP");
	    	}
	    
	}
*/
}

