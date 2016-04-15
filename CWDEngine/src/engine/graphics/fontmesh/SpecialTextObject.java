package engine.graphics.fontmesh;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class SpecialTextObject {
	
	private Vector3f color = new Vector3f(0, 0, 0);
	private Vector3f borderColor = new Vector3f(0, 0, 0);
	private float borderWidth = 0;
	private Vector2f borderOffset = new Vector2f(0,0);
	private boolean isHighLevelRender = false;
	
	public SpecialTextObject() {
		
	}
	
	public SpecialTextObject(Vector3f color, Vector3f borderColor, float borderWidth, Vector2f borderOffset, boolean highLevelRender) {
		this.color = color;
		this.borderColor = borderColor;
		this.borderWidth = borderWidth;
		this.borderOffset = borderOffset;
		this.isHighLevelRender = highLevelRender;
	}
	
	public Vector3f getColor() {
		return color;
	}

	public void setColor(Vector3f color) {
		this.color = color;
	}

	public Vector3f getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Vector3f borderColor) {
		this.borderColor = borderColor;
	}

	public float getBorderWidth() {
		return borderWidth;
	}

	public void setBorderWidth(float borderWidth) {
		this.borderWidth = borderWidth;
	}

	public Vector2f getBorderOffset() {
		return borderOffset;
	}

	public void setBorderOffset(Vector2f borderOffset) {
		this.borderOffset = borderOffset;
	}

	public boolean isHighLevelRender() {
		if (!TextHandler.SpecialText)
			return false;
		return isHighLevelRender;
	}

	public void setHighLevelRender(boolean isHighLevelRender) {
		this.isHighLevelRender = isHighLevelRender;
	}

}
