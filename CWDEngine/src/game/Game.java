package game;

import org.lwjgl.opengl.Display;

import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.MainRendererHandler;
import engine.graphics.fontmesh.TextHandler;
import engine.graphics.stateengine.StateEngine;
import engine.graphics.stateengine.states.GameState;
import engine.graphics.stateengine.states.PauseState;

public class Game {
	
	public static StateEngine stateRunner;
	public static Loader loader;
	public Game() {
		DisplayManager.createDisplay();
		
		loader = new Loader();
		MainRendererHandler renderer = new MainRendererHandler(loader);
		TextHandler.init(loader);
		TextHandler.SpecialText = false;
		StaticVar.init();

		// **************** State engine to organize each state, holding a map of all states

		stateRunner = new StateEngine();
		GameState gameState = new GameState(loader, renderer, stateRunner);
		new PauseState(stateRunner, loader);
		
		//****************Game Loop Below*********************
		while (!Display.isCloseRequested()) {
			stateRunner.update();
			stateRunner.render();
			TextHandler.render();
			DisplayManager.updateDisplay();
		}

		//Clean up methods
		gameState.cleanUp();
		DisplayManager.closeDisplay();
		
	}
	
	public static void main(String[] args) {
		new Game();
	}
	
}
