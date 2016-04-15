package engine.graphics.textures;

public class Texture {
	
	private int textureID;
	private int normalMap;
	
	private float shineDamper = 1;
	private float reflectivity = 0;
	
	private boolean transparency = false;
	private boolean trickLighting = false;
	
	private int numberOfRows = 1;
	
	public Texture(int texture){
		this.textureID = texture;
	}
		
	public int getNumberOfRows() {
		return numberOfRows;
	}

	public int getNormalMap() {
		return normalMap;
	}

	public void setNormalMap(int normalMap) {
		this.normalMap = normalMap;
	}

	public void setNumberOfRows(int numberOfRows) {
		this.numberOfRows = numberOfRows;
	}

	public boolean hasTransparency() {
		return transparency;
	}

	public boolean useTrickLighting() {
		return trickLighting;
	}


	public void setUseTrickLighting(boolean trickLighting) {
		this.trickLighting = trickLighting ;
	}

	public void setHasTransparency(boolean transparency) {
		this.transparency = transparency;
	}


	public int getID(){
		return textureID;
	}

	public float getShineDamper() {
		return shineDamper;
	}

	public void setShineDamper(float shineDamper) {
		this.shineDamper = shineDamper;
	}

	public float getReflectivity() {
		return reflectivity;
	}

	public void setReflectivity(float reflectivity) {
		this.reflectivity = reflectivity;
	}

}
