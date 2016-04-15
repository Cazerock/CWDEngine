package engine.graphics;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import engine.graphics.shaders.ShaderProgram;

public class FontShader extends ShaderProgram {

	private static final String VERTEX_FILE = "src/shaders/fontVertex.txt";
	private static final String FRAGMENT_FILE = "src/shaders/fontFragment.txt";
	
	private int location_colour;
	private int location_translation;
	private int location_isFancyFont;
	private int location_borderEdge;
	private int location_borderColor;
	
	//TODO add border offset value
	private int location_borderOffset;
	
	public FontShader() {
		super(VERTEX_FILE, FRAGMENT_FILE);
	}

	@Override
	protected void getAllUniformLocations() {
		location_colour = super.getUniformLocation("colour");
		location_translation = super.getUniformLocation("translation");
		location_isFancyFont = super.getUniformLocation("isFancy");
		location_borderColor = super.getUniformLocation("outlineColor");
		location_borderEdge = super.getUniformLocation("borderEdge");
		location_borderOffset = super.getUniformLocation("offset");
	}

	@Override
	protected void bindAttributes() {
		super.bindAttribute(0, "position");
		super.bindAttribute(1, "textureCoords");
	}
	
	protected void loadColor(Vector3f colour){
		super.loadVector(location_colour, colour);
	}
	
	protected void loadBorderColor(Vector3f color) {
		super.loadVector(location_borderColor, color);
	}
	
	protected void loadBorderEdge(float edge) {
		super.loadFloat(location_borderEdge, edge);
	}
	
	protected void loadBorderOffset(Vector2f offset) {
		super.load2DVector(location_borderOffset, offset);
	}
	
	protected void isFancyFont(boolean fancy) {
		super.loadBoolean(location_isFancyFont, fancy);
	}
	
	protected void loadTranslation(Vector2f translation){
		super.load2DVector(location_translation, translation);
	}


}
