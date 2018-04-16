package com.decre.main.level;

public class TileCoordinate {

	private int x, y;
	private final int TILE_SIZE = 16;

	public TileCoordinate(int x, int y) {
		this.x = x * TILE_SIZE;
		this.y = y * TILE_SIZE;
	}

	public int X() {
		return x;
	}

	public int Y() {
		return y;
	}

	public int[] XY() {
		int[] r = { x, y };
		return r;
	}

}
