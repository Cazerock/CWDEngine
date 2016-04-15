package engine.graphics.buttons;

import java.util.List;

import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector2f;

import renderEngine.DisplayManager;
import renderEngine.Loader;
import engine.graphics.GuiTexture;

public abstract class AbstractButton implements IButton {
	
	private GuiTexture texture;
	
	private Vector2f originalScale;
	
	private boolean isHidden = false, isHovering = false;
	
	public AbstractButton(Loader loader, String texture, Vector2f position, Vector2f scale) {
		this.texture = new GuiTexture(loader.loadTexture(texture), position, scale);
		originalScale = scale;
	}
	
	public void update() {
		if (!isHidden) {
			Vector2f location = texture.getPosition();
			Vector2f scale = texture.getScale();
			
			Vector2f mouseCoords = DisplayManager.getNormalizedMouseCoord();
			
			if (location.y + scale.y > -mouseCoords.y && location.y - scale.y < -mouseCoords.y 
					&& location.x + scale.x > mouseCoords.x && location.x - scale.x < mouseCoords.x) {
				whileHovering(this);
				if (!isHovering) {
					isHovering = true;
					onStartHover(this);
				}
				
				while (Mouse.next()) {
					if (Mouse.isButtonDown(0)) {
						onClick(this);
					}
				}
			} else {
				if (isHovering)	{
					isHovering = false;
					onStopHover(this);
				}
			}
		}
	}
	
	@Override
	public void show(List<GuiTexture> guiTextureList) {
//		if (isHidden) {
			guiTextureList.add(texture);
			isHidden = false;
//		}
	}
	
	@Override
	public void hide(List<GuiTexture> guiTextureList) {
		if (!isHidden) {
			guiTextureList.remove(texture);
			isHidden = true;
		}
	}
	
	@Override
	public void resetScale() {
		texture.setScale(originalScale);
	}
	
	@Override
	public void playerHoverAnimation(float scaleFactor) {
		texture.setScale(new Vector2f(originalScale.x + scaleFactor, originalScale.y + scaleFactor));
	}

	public GuiTexture getTexture() {
		return texture;
	}

	public void setTexture(GuiTexture texture) {
		this.texture = texture;
	}

	public Vector2f getOriginalScale() {
		return originalScale;
	}

	public void setOriginalScale(Vector2f originalScale) {
		this.originalScale = originalScale;
	}

	public boolean isHidden() {
		return isHidden;
	}

	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}

	public boolean isHovering() {
		return isHovering;
	}

	public void setHovering(boolean isHovering) {
		this.isHovering = isHovering;
	}
	
	
	
}
