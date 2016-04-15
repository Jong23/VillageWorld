package GUI;

import org.lwjgl.opengl.Display;

import GUI.Map.TileGrid2;

import static helpers.Artist.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Boot {
	
	
	public Boot(){
		beginSession();
		

		
		while(!Display.isCloseRequested()){
			
			StateManager.update();
			
			Display.update();
			Display.sync(60);
			
		}
		Display.destroy();
	}

	public static void main(String[] args){
		new Boot();
//		int[][] i= new int[1][1];
//		try {
//			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.data"));
//			oos.writeObject(i);
//			System.out.println("gespeichert!");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//			try {
//				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.data"));
//				try {
//					i=(int[][]) ois.readObject();
//					System.out.println(i +" geladen!");
//				} catch (ClassNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	}
	
}
