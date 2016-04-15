package Editor;


import static org.lwjgl.opengl.GL11.glOrtho;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.glu.GLU;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

import GUI.Map.TileGrid;
import GUI.Map.TileGrid2;
import GUI.Map.TileType;
import GUI.StateManager.GameState;
import GUI.StateManager;
import GUI.UI;

import static helpers.Artist.*;

public class Editor {
	
	private TileGrid2 map;
	private UI editorUI;
	private TileType selectedTile;
	
	public Editor(){
		editorUI = new UI();
		this.map = new TileGrid2(160,80);

		selectedTile = TileType.Grass;
		editorUI.addButton("EditorGrass",loadTexture("grass"),WIDTH-64, 0);
		editorUI.addButton("EditorDirt",loadTexture("dirt"), WIDTH-64,64);
		editorUI.addButton("EditorWater",loadTexture("water"),WIDTH-64,128);
		editorUI.addButton("EditorSand",loadTexture("sand"),WIDTH-64,192);
		editorUI.addButton("EditorTree",loadTexture("tree"),WIDTH-64,256);
		editorUI.addButton("EditorMountain",loadTexture("mountain"),WIDTH-64,320);
		editorUI.addButton("EditorQuit",loadTexture("Button_MainMenu_Quit"),0,0);
		editorUI.addButton("EditorSave",loadTexture("Button_Save"),254,0);
		editorUI.addButton("EditorLoad",loadTexture("Button_Load"),508,0);

	}
	
	private boolean updateButtons(){
		if(Mouse.isButtonDown(0)){
			if(editorUI.isButtonClicked("EditorGrass")){
				System.out.println("Button pressed");
				selectedTile = TileType.Grass;
				return true;
			}
			if(editorUI.isButtonClicked("EditorDirt")){
				selectedTile = TileType.Dirt;
				return true;
			}
			if(editorUI.isButtonClicked("EditorWater")){
				selectedTile = TileType.Water;
				return true;
			}
			if(editorUI.isButtonClicked("EditorSand")){
				selectedTile = TileType.Sand;
				return true;
			}
			if(editorUI.isButtonClicked("EditorTree")){
				selectedTile = TileType.Tree;
				return true;
			}
			if(editorUI.isButtonClicked("EditorMountain")){
				selectedTile = TileType.Mountain;
				return true;
			}
			if(editorUI.isButtonClicked("EditorQuit")){
				StateManager.setState(GameState.MAINMENU);
				
				return true;
			}
			// saving and loading tilegrids (still under construction)
			if(editorUI.isButtonClicked("EditorSave")){
				try {
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("map.data"));
					oos.writeObject(this.map);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}
			if(editorUI.isButtonClicked("EditorLoad")){
				try {
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream("map.data"));
					try {
						this.map=(TileGrid2) ois.readObject();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}
		}
		return false;
	}
	
	public void update(){
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
			map.incrementOffsetX();

		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
			map.decrementOffsetX();

		}
		if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)){
			map.incrementOffsetY();

		}
		if(Keyboard.isKeyDown(Keyboard.KEY_UP)){
			map.decrementOffsetY();

		}

		//Handle Mouse Input
		if(Mouse.isButtonDown(0) && !updateButtons()){
			setTile(selectedTile);
		}
		
	    int dWheel = Mouse.getDWheel();
	    
	    if (dWheel < 0) {
	        map.zoomOut();
	        System.out.println(dWheel);
	    } else if (dWheel > 0){
	        map.zoomIn();
	        System.out.println(dWheel);
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
