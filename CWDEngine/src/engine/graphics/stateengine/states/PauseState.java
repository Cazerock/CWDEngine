package engine.graphics.stateengine.states;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import renderEngine.Loader;
import engine.graphics.GuiText;
import engine.graphics.fontmesh.SpecialTextObject;
import engine.graphics.fontmesh.TextHandler;
import engine.graphics.fontmesh.TextPositionObject;
import engine.graphics.stateengine.IState;
import engine.graphics.stateengine.StateEngine;

public class PauseState implements IState {
	
	StateEngine engine;
	GuiText pauseTitle;
	SpecialTextObject st;
	TextPositionObject po;

	
	public boolean justStarted = true;
	
	public PauseState(StateEngine engine, Loader loader) {
		this.engine = engine;
		init();
	}
	
	public void init() {
		engine.stateMap.put(getID(), this);
		st = new SpecialTextObject(new Vector3f(1, 1f, 0), new Vector3f(.45f, .45f, .45f), .05f, new Vector2f(.004f, 0), true);
		po = new TextPositionObject(8f, new Vector2f(0, 0), 1f, true);
		pauseTitle = new GuiText("PAUSE", TextHandler.invFont, st, po, StateEngine.PauseState);
		new GuiText("Hit \"G\" to go back to Game ", TextHandler.invFont, st, new TextPositionObject(2f, new Vector2f(0, .23f), 1f, true), StateEngine.PauseState);
		System.out.println(getID() + " state has been initialized");
	}

	public void postProcess() {
		
	}

	public void update() {
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))
			System.exit(-1);
		
		if (Keyboard.isKeyDown(Keyboard.KEY_G)) {
			justStarted = true;
			engine.changeState(StateEngine.GameState);
		}
		
		while (Keyboard.next()) {
			if (Keyboard.getEventKeyState()) {
				if (Keyboard.getEventKey() == Keyboard.KEY_TAB) {
					if (Mouse.isGrabbed()) {
						Mouse.setGrabbed(false);
					} else if (!Mouse.isGrabbed()) {
						Mouse.setGrabbed(true);
					}
				}
			}
		}

	
		
	}

	public void render() {
//		GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.02f );
//		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

	}

	public int getID() {
		return StateEngine.PauseState;
	}
	
	
	
}
