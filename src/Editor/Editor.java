package Editor;


import static org.lwjgl.opengl.GL11.glOrtho;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.glu.GLU;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

import GUI.Map.TileGrid;
import GUI.Map.TileType;
import GUI.StateManager.GameState;
import GUI.StateManager;
import GUI.UI;

import static helpers.Artist.*;

public class Editor {
	
	private TileGrid map;
	private UI editorUI;
	private TileType selectedTile;
	
	public Editor(){
		editorUI = new UI();
		this.map = new TileGrid(160,120);

		selectedTile = TileType.Grass;
		editorUI.addButton("EditorGrass",loadTexture("grass"),WIDTH-64, 0);
		editorUI.addButton("EditorDirt",loadTexture("dirt"), WIDTH-64,64);
		editorUI.addButton("EditorWater",loadTexture("water"),WIDTH-64,128);
		editorUI.addButton("EditorSand",loadTexture("sand"),WIDTH-64,192);
		editorUI.addButton("EditorTree",loadTexture("tree"),WIDTH-64,256);
		editorUI.addButton("EditorMountain",loadTexture("mountain"),WIDTH-64,320);
		editorUI.addButton("EditorQuit",loadTexture("Button_MainMenu_Quit"),0,0);

	}
	
	private void updateButtons(){
		if(Mouse.isButtonDown(0)){
			if(editorUI.isButtonClicked("EditorGrass")){
				System.out.println("Button pressed");
				selectedTile = TileType.Grass;
			}
			if(editorUI.isButtonClicked("EditorDirt")){
				selectedTile = TileType.Dirt;
			}
			if(editorUI.isButtonClicked("EditorWater")){
				selectedTile = TileType.Water;
			}
			if(editorUI.isButtonClicked("EditorSand")){
				selectedTile = TileType.Sand;
			}
			if(editorUI.isButtonClicked("EditorTree")){
				selectedTile = TileType.Tree;
			}
			if(editorUI.isButtonClicked("EditorMountain")){
				selectedTile = TileType.Mountain;
			}
			if(editorUI.isButtonClicked("EditorQuit")){
				StateManager.setState(GameState.MAINMENU);
			}
		}
	}
	
	public void update(){
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
			System.out.println("right pressed");
			map.incrementOffsetX();

		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
			System.out.println("Left pressed");
			map.decrementOffsetX();

		}
		if(Keyboard.isKeyDown(Keyboard.KEY_UP)){
			System.out.println("UP pressed");
			map.incrementZoom();

		}
		if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)){
			System.out.println("Down pressed");
			map.decrementZoom();

		}

		//Handle Mouse Input
		if(Mouse.isButtonDown(0)){
			setTile(selectedTile);
		}
		
		map.draw();
		editorUI.draw();
		updateButtons();

	}
	
	public void setTile(TileType type){
			//map.setTile((int) Math.floor(Mouse.getX()/32),(int)Math.floor((HEIGHT-Mouse.getY()-1)/32), type);
		map.setTile(Mouse.getX(), HEIGHT-Mouse.getY()-1, type);
	}

}
