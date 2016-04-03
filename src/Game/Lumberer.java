package Game;

import java.util.Date;

public class Lumberer extends Building {
	public Lumberer(int x, int y) {
		super(x, y, 2, 3);
	}

	@Override
	public void produce() {
		System.out.println(new Date().getTime());
	}

}
