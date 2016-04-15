package engine.graphics;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import engine.graphics.fontmesh.SpecialTextObject;
import engine.graphics.fontmesh.TextHandler;
import engine.graphics.fontmesh.TextPositionObject;

/**
 * Represents a piece of text in the game.
 * 
 * @author Karl
 *
 */
public class GuiText {

	private String textString;
	private float fontSize;

	private int textMeshVao;
	private int vertexCount;
	
	//special text object
	private Vector3f color = new Vector3f(0f, 0f, 0f);
	private Vector3f borderColor;
	private Vector2f borderOffset;
	private float borderWidth;
	
	//text position object
	private Vector2f position;
	private float lineMaxSize;
	private int numberOfLines;
	private boolean centerText = false;

	private FontType font;
	private int state;
	
	private SpecialTextObject so;
	
	public GuiText(String text, FontType font, SpecialTextObject specialObject, 
			TextPositionObject postionObject, int state) {
		this.so = specialObject;
		this.textString = text;
		this.font = font;
		this.state = state;
		this.fontSize = postionObject.getSize();
		this.centerText = postionObject.isCentered();
		this.lineMaxSize = postionObject.getMaxLineLength();
		this.position = postionObject.getPosition();
		
		this.color = specialObject.getColor();
		this.borderColor = specialObject.getBorderColor();
		this.borderOffset = specialObject.getBorderOffset();
		this.borderWidth = specialObject.getBorderWidth();
		
		TextHandler.loadText(this);
	}

	public Vector3f getBorderColor() {
		return borderColor;
	}

	public Vector2f getBorderOffset() {
		return borderOffset;
	}

	public float getBorderWidth() {
		return borderWidth;
	}

	public void replace(String newText) {
		this.textString = newText;
		remove();
		TextHandler.loadText(this);
	}
	
	/**
	 * Remove the text from the screen.
	 */
	public void remove() {
		TextHandler.removeText(this);
	}

	/**
	 * @return The font used by this text.
	 */
	public FontType getFont() {
		return font;
	}

	public int getState() {
		return state;
	}
	
	public boolean isHighLevelRender() {
		return so.isHighLevelRender();
	}

	public void setColor(float r, float g, float b) {
		color.set(r, g, b);
	}
	
	public void setString(String newText) {
		textString = newText;
	}
	

	public Vector3f getColor() {
		return color;
	}


	public int getNumberOfLines() {
		return numberOfLines;
	}

	public Vector2f getPosition() {
		return position;
	}
	
	public int getMesh() {
		return textMeshVao;
	}

	/**
	 * Set the VAO and vertex count for this text.
	 * 
	 * @param vao
	 *            - the VAO containing all the vertex data for the quads on
	 *            which the text will be rendered.
	 * @param verticesCount
	 *            - the total number of vertices in all of the quads.
	 */
	public void setMeshInfo(int vao, int verticesCount) {
		this.textMeshVao = vao;
		this.vertexCount = verticesCount;
	}

	/**
	 * @return The total number of vertices of all the text's quads.
	 */
	public int getVertexCount() {
		return this.vertexCount;
	}

	/**
	 * @return the font size of the text (a font size of 1 is normal).
	 */
	public float getFontSize() {
		return fontSize;
	}

	/**
	 * Sets the number of lines that this text covers (method used only in
	 * loading).
	 * 
	 * @param number
	 */
	public void setNumberOfLines(int number) {
		this.numberOfLines = number;
	}

	/**
	 * @return {@code true} if the text should be centered.
	 */
	public boolean isCentered() {
		return centerText;
	}

	/**
	 * @return The maximum length of a line of this text.
	 */
	public float getMaxLineSize() {
		return lineMaxSize;
	}

	/**
	 * @return The string of text.
	 */
	public String getTextString() {
		return textString;
	}
	
	public void setText(String t) {
		textString = t;
	}
	
}
