package GUI;

import GUI.Map.TileGrid;

public class StateManager {
	
	public static enum GameState {
		MAINMENU, GAME, EDITOR
	}
	
	public static GameState gameState = GameState.MAINMENU;
	public static MainMenu mainMenu;
	public static Game game;
	public static Editor editor;
	public static TileGrid map;
	
	public static void update(){
		switch(gameState){
		case MAINMENU:
			if(mainMenu==null){
				mainMenu = new MainMenu();
			}
			mainMenu.update();
			break;
		
		case GAME:
			if(game==null){
				
				map = new TileGrid();
				game= new Game(map);
			}
			game.update();
			break;
		
		case EDITOR:
			
			break;
		}
	}
	
	public static void setState(GameState newState){
		gameState = newState;
	}
}
