package com.decre.main.graphics;

public class Sprite {

	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;

	public static Sprite grass = new Sprite(16, 0, 5, SpriteSheet.tiles);
	public static Sprite flower = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite rock = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0x1b87e0);

	// Spawn Level Sprites:
	public static Sprite spawnGrass = new Sprite(16, 0, 0, SpriteSheet.spawnTiles);
	public static Sprite spawnHedge = new Sprite(16, 1, 0, SpriteSheet.spawnTiles);
	public static Sprite spawnWater = new Sprite(16, 2, 0, SpriteSheet.spawnTiles);
	public static Sprite spawnWall1 = new Sprite(16, 0, 1, SpriteSheet.spawnTiles);
	public static Sprite spawnWall2 = new Sprite(16, 0, 2, SpriteSheet.spawnTiles);
	public static Sprite spawnFloor = new Sprite(16, 1, 1, SpriteSheet.spawnTiles);

	// Player Sprites
	public static Sprite playerUp = new Sprite(32, 0, 5, SpriteSheet.tiles);
	public static Sprite playerUp_1 = new Sprite(32, 0, 6, SpriteSheet.tiles);
	public static Sprite playerUp_2 = new Sprite(32, 0, 7, SpriteSheet.tiles);
	public static Sprite playerDown = new Sprite(32, 2, 5, SpriteSheet.tiles);
	public static Sprite playerDown_1 = new Sprite(32, 2, 6, SpriteSheet.tiles);
	public static Sprite playerDown_2 = new Sprite(32, 2, 7, SpriteSheet.tiles);
	public static Sprite playerSide = new Sprite(32, 1, 5, SpriteSheet.tiles);
	public static Sprite playerSide_1 = new Sprite(32, 1, 6, SpriteSheet.tiles);
	public static Sprite playerSide_2 = new Sprite(32, 1, 7, SpriteSheet.tiles);

	// Projectile Sprites
	public static Sprite wizardProjectile = new Sprite(16, 0, 0, SpriteSheet.WizardProjectiles);

	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		this.SIZE = size;
		pixels = new int[size * size];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}

	public Sprite(int size, int color) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);
	}

	private void setColor(int color) {
		for (int i = 0; i < SIZE; i++) {
			pixels[i] = color;
		}
	}

	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}

}
