package Map;

import java.io.IOException;
import java.io.InputStream;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;


public class Field {
	FieldType type;
	public int x,y;
	Texture texture = null;
	public Field(FieldType t, int x, int y){
		type = t;
		this.x = x;
		this.y = y;
	}
	public Field(int x, int y){
		type = FieldType.GRAS;
		this.x = x;
		this.y = y;
	}
	public FieldType getType() {
		return type;
	}
	public void setType(FieldType type) {
		this.type = type;
	}
	public Texture getTexture() {
		if(texture == null){
			if(type == FieldType.GRAS){
//				texture = loadTexture("Gras");
			}
		}
		return loadTexture("Gras");
	}
	public static Texture loadTexture(String name){
		InputStream in = ResourceLoader.getResourceAsStream("res/"+name+".png");
		try {
			return TextureLoader.getTexture("PNG", in);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
