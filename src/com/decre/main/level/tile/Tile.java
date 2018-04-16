package com.decre.main.level.tile;

import com.decre.main.graphics.Screen;
import com.decre.main.graphics.Sprite;
import com.decre.main.level.tile.spawnlevel.SpawnFloorTile;
import com.decre.main.level.tile.spawnlevel.SpawnGrassTile;
import com.decre.main.level.tile.spawnlevel.SpawnHedgeTile;
import com.decre.main.level.tile.spawnlevel.SpawnWallTile;
import com.decre.main.level.tile.spawnlevel.SpawnWaterTile;

public class Tile {

	public int x, y;
	public Sprite sprite;

	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile flower = new FLowerTile(Sprite.flower);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);

	// Spawn Tiles:
	public static Tile spawnGrass = new SpawnGrassTile(Sprite.spawnGrass);
	public static Tile spawnHedge = new SpawnHedgeTile(Sprite.spawnHedge);
	public static Tile spawnWater = new SpawnWaterTile(Sprite.spawnWater);
	public static Tile spawnWall1 = new SpawnWallTile(Sprite.spawnWall1);
	public static Tile spawnWall2 = new SpawnWallTile(Sprite.spawnWall2);
	public static Tile spawnFloor = new SpawnFloorTile(Sprite.spawnFloor);

	// Tile Color Codes:
	public static final int colSpawnGrass = 0xff00ff00;
	public static final int colSpawnHedge = 0;
	public static final int colSpawnWater = 0;
	public static final int colSpawnWall1 = 0xff808080;
	public static final int colSpawnWall2 = 0xff303030;
	public static final int colSpawnFloor = 0xff724715;

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {

	}

	public boolean solid() {
		return false;
	}

}
