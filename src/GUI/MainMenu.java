package GUI;

import static helpers.Artist.*;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

import GUI.StateManager.GameState;

public class MainMenu {

	private Texture background;
	private UI menuGUI;
	
	public MainMenu(){
		background = loadTexture("MainMenu");
		menuGUI = new UI();
		menuGUI.addButton("New Game", loadTexture("Button_MainMenu_NewGame"),(int) (WIDTH*0.5f)-128,(int) (HEIGHT*0.45f));
		menuGUI.addButton("Load Game", loadTexture("Button_MainMenu_LoadGame"),(int) (WIDTH*0.5f)-128,(int) (HEIGHT*0.55f));
		menuGUI.addButton("Editor", loadTexture("Button_MainMenu_Editor"),(int) (WIDTH*0.5f)-128,(int) (HEIGHT*0.65f));
		menuGUI.addButton("Options", loadTexture("Button_MainMenu_Options"),(int) (WIDTH*0.5f)-128,(int) (HEIGHT*0.75f));
		menuGUI.addButton("Quit", loadTexture("Button_MainMenu_Quit"),(int) (WIDTH*0.5f)-128,(int) (HEIGHT*0.85f));
	}
	
	private void updateButtons(){
		if(Mouse.isButtonDown(0)){
			if(menuGUI.isButtonClicked("New Game")){
				StateManager.setState(GameState.GAME);
			}
			if(menuGUI.isButtonClicked("Load Game")){
				StateManager.setState(GameState.GAME);
			}
			if(menuGUI.isButtonClicked("Editor")){
				StateManager.setState(GameState.EDITOR);
			}
			if(menuGUI.isButtonClicked("Options")){
				StateManager.setState(GameState.GAME);
			}
			if(menuGUI.isButtonClicked("Quit")){
				System.exit(0);
			}
		}
	}
	
	public void update(){
		drawQuadTex(background, 0, 0, 2048, 1024,0);
		menuGUI.draw();
		updateButtons();
	}
}
