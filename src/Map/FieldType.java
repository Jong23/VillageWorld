package Map;

import java.awt.Color;

public enum FieldType {
	SEA(new Color(0,0,255)),
	COAST(new Color(255,153,51)),
	HILL(new Color(51,25,0)),
	GRAS(new Color(0,153,0)),
	RIVER(new Color(0,128,255));
	private Color color;
	public Color getColor(){
		return color;
	}
	FieldType(Color c){
		color = c;
	}
}
