package helpers;

import static org.lwjgl.opengl.GL11.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Artist {
	
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 960;
	public static HashMap<String, Texture> textures = new HashMap<>();
	
	public static void beginSession(){
		Display.setTitle("Village World");
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0,WIDTH,HEIGHT,0,1,-1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
	}
	
	public static void drawQuad(float x, float y, float width, float height){
		glBegin(GL_QUADS);
		glVertex2f(x,y);				// top-left
		glVertex2f(x+width,y);			// top-right
		glVertex2f(x+width,y+height);	// bottom-right
		glVertex2f(x,y+height);			// bottom-left
		glEnd();
	}
	
	public static void drawQuadTex(Texture tex, float x, float y, float width, float height, float angle){
		tex.bind();
		if(angle==0){
			glTranslatef(x,y,0);
		}
		else{
			glTranslatef(x+width/2,y+height/2,0);
			glRotatef(angle,0,0,1);
			glTranslatef(-width/2, -height/2,0);	
		}

		glBegin(GL_QUADS);
		glTexCoord2f(0,0);
		glVertex2f(0,0);
		glTexCoord2f(1,0);
		glVertex2f(width,0);
		glTexCoord2f(1,1);
		glVertex2f(width,height);
		glTexCoord2f(0,1);
		glVertex2f(0,height);
		glEnd();
		glLoadIdentity();
	}
	
	public static void drawBlackFramePart(float x, float y, float width, float height){
//		glTranslatef(x,y,0);
//		glColor3f(255, 255, 255);
//		glBegin(GL_QUADS);
//		glVertex2f(0,0);
//		glVertex2f(width,0);
//		glVertex2f(width,height);
//		glVertex2f(0,height);
//		glEnd();
//		glLoadIdentity();
		drawQuadTex(loadTexture("black"), x, y, width, height, 0);
		
		
	}
	public static Texture loadTexture(String name){
		
		if(textures.containsKey(name)){ 
			return textures.get(name);
		} else {
			InputStream in = ResourceLoader.getResourceAsStream("res/" +name+".png");
			try {
				Texture tex = TextureLoader.getTexture("png", in);
				textures.put(name, tex);
				return tex;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
		
}
