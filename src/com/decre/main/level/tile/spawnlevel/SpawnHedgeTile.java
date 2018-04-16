package com.decre.main.level.tile.spawnlevel;

import com.decre.main.graphics.Screen;
import com.decre.main.graphics.Sprite;
import com.decre.main.level.tile.Tile;

public class SpawnHedgeTile extends Tile {

	public SpawnHedgeTile(Sprite sprite) {
		super(sprite);
	}
	
	@Override
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}

	@Override
	public boolean solid() {
		return true;
	}
	
	

}
