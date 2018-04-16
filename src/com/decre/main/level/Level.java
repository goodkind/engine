package com.decre.main.level;

import com.decre.main.graphics.Screen;
import com.decre.main.level.tile.Tile;

public class Level {

	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;

	public static Level spawn = new SpawnLevel("/levels/spawn.png");

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}

	protected void generateLevel() {

	}

	protected void loadLevel(String path) {

	}

	public void update() {

	}

	private void time() {

	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
	}

	// Grass = 0xff00
	// Flower = 0xffff00
	// Rock = 0x7f7f00
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		if (tiles[x + y * width] == Tile.colSpawnGrass) return Tile.spawnGrass;
		if (tiles[x + y * width] == Tile.colSpawnHedge) return Tile.spawnHedge;
		if (tiles[x + y * width] == Tile.colSpawnWall1) return Tile.spawnWall1;
		if (tiles[x + y * width] == Tile.colSpawnWall2) return Tile.spawnWall2;
		if (tiles[x + y * width] == Tile.colSpawnWater) return Tile.spawnWater;
		if (tiles[x + y * width] == Tile.colSpawnFloor) return Tile.spawnFloor;

		return Tile.voidTile;
	}

}
