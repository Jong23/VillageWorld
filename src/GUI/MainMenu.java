package GUI;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

import GUI.StateManager.GameState;

import static GUI.Artist.*;

public class MainMenu {

	private Texture background;
	private UI menuGUI;
	
	public MainMenu(){
		background = loadTexture("mainmenuexample");
		menuGUI = new UI();
		menuGUI.addButton("Play", loadTexture("playbuttonexample"),(int) (WIDTH*0.5f)-128,(int) (HEIGHT*0.45f));
	}
	
	private void updateButtons(){
		if(Mouse.isButtonDown(0)){
			if(menuGUI.isButtonClicked("Play")){
				StateManager.setState(GameState.GAME);
			}
		}
	}
	
	public void update(){
		drawQuadTex(background, 0, 0, 2048, 1024,0);
		menuGUI.draw();
		updateButtons();
	}
}
