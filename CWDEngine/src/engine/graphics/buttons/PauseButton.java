package engine.graphics.buttons;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import renderEngine.Loader;
import engine.graphics.GuiText;
import engine.graphics.fontmesh.SpecialTextObject;
import engine.graphics.fontmesh.TextHandler;
import engine.graphics.fontmesh.TextPositionObject;
import engine.graphics.stateengine.StateEngine;
import game.Game;




public class PauseButton extends AbstractButton {
	
	private GuiText text;
	
	public PauseButton(Loader loader, String texture, Vector2f position,
			Vector2f scale) {
		super(loader, texture, position, scale);
		SpecialTextObject st = new SpecialTextObject(new Vector3f(1, 1, 1), new Vector3f(0, 0, 0), .1f, new Vector2f(.008f, 0), true);
		text = new GuiText("Pause", TextHandler.invFont, st, new TextPositionObject(1.75f, new Vector2f(.519999f, 1-.095f), 1, false), StateEngine.GameState);
		text.remove();
	}

	public void onClick(IButton button) {
		Game.stateRunner.changeState(StateEngine.PauseState);
	}

	public void onStartHover(IButton button) {
		TextHandler.loadText(text);
		playerHoverAnimation(.02f);
	}

	public void onStopHover(IButton button) {
		text.remove();
		resetScale();
	}

	@Override
	public void whileHovering(IButton button) {
		
	}

}
