package engine.graphics.textures;

public class TerrainPack {
	
	private TerrainImage backgroundTexture;
	private TerrainImage rTexture;
	private TerrainImage gTexture;
	private TerrainImage bTexture;
	
	public TerrainPack(TerrainImage backgroundTexture, TerrainImage rTexture,
			TerrainImage gTexture, TerrainImage bTexture) {
		this.backgroundTexture = backgroundTexture;
		this.rTexture = rTexture;
		this.gTexture = gTexture;
		this.bTexture = bTexture;
	}

	public TerrainImage getBackgroundTexture() {
		return backgroundTexture;
	}

	public TerrainImage getrTexture() {
		return rTexture;
	}

	public TerrainImage getgTexture() {
		return gTexture;
	}

	public TerrainImage getbTexture() {
		return bTexture;
	}


}
