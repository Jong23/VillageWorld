package Map;

import Game.Constants;

public class Map {
	Field [][] fields;
	Map(int width, int height){
		fields = new Field[width][height];
		for (int x = 0; x < fields.length; x++) {
			for (int y = 0; y < fields[x].length; y++) {
				fields[x][y] = new Field(x*Constants.TILESIZE, y*Constants.TILESIZE);
			}
		}
	}
	public void setTypeOfField(int x, int y, FieldType type){
		fields[x][y].setType(type);
	}
	public Field[][] getFields(){
		return fields;
	}
}
