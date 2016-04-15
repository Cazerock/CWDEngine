package engine.graphics.particles;

public class ParticleImage {

	private int textureID;
	private int numberOfRows;
	private boolean additive = false;
	
	
	public ParticleImage(int textureID, int numberOfRows) {
		this.textureID = textureID;
		this.numberOfRows = numberOfRows;
	}
	
	public boolean isAdditive() {
		return additive;
	}

	public void setAdditive(boolean additive) {
		this.additive = additive;
	}



	public int getTextureID() {
		return this.textureID;
	}
	public int getNumberOfRows() {
		return this.numberOfRows;
	}
	
	
	
}
