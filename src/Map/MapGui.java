package Map;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.newdawn.slick.opengl.Texture;

import Game.Constants;
import sun.font.GlyphDisposedListener;


import static org.lwjgl.opengl.GL11.*;

public class MapGui{
	Map map;
	int size = Constants.TILESIZE;
	
	public MapGui(int width, int height) {
		map = new Map(width, height);
	}

	public void draw() {
		Field [][] field = map.getFields();
		for (int x = 0; x < field.length; x++) {
			for (int y = 0; y < field[x].length; y++) {
				drawTile(field[x][y]);
			}
		}

	}
	public void drawTile(Field field){
		field.getTexture().bind();
		glTranslatef(field.x, field.y, 0);
		glBegin(GL_QUADS);
		glTexCoord2f(0,0);
		glVertex2f(0, 0);
		glTexCoord2f(1,0);
		glVertex2f(size, 0);
		glTexCoord2f(1,1);
		glVertex2f(size, size);
		glTexCoord2f(0,1);
		glVertex2f(0, size);
		glEnd();
		glLoadIdentity();
	}
	
}
