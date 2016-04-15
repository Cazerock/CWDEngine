package engine.graphics.fontmesh;

import org.lwjgl.util.vector.Vector2f;

public class TextPositionObject {

	private Vector2f position = new Vector2f(0, 0);
	private float maxLineLength = 1f;
	private boolean centered = false;
	private float size;
	public TextPositionObject() {
		
	}

	public TextPositionObject(float size, Vector2f postion, float lineLength, boolean isCentered) {
		this.size = size;
		this.position = postion;
		this.maxLineLength = lineLength;
		this.centered = isCentered;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public Vector2f getPosition() {
		return position;
	}

	public void setPosition(Vector2f position) {
		this.position = position;
	}

	public float getMaxLineLength() {
		return maxLineLength;
	}

	public void setMaxLineLength(float maxLineLength) {
		this.maxLineLength = maxLineLength;
	}

	public boolean isCentered() {
		return centered;
	}

	public void setCentered(boolean centered) {
		this.centered = centered;
	}
	
}
