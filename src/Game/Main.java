package Game;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import Buildings.StorageBuilding;
import Map.MapGui;

import static org.lwjgl.opengl.GL11.*;

public class Main {

	public static void main(String[] args) {
		Island i = new Island();
		i.addBuilding(new StorageBuilding(0, 0));
	}

}
