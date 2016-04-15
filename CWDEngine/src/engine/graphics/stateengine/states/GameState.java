package engine.graphics.stateengine.states;

import java.util.List;
import java.util.Random;

import models.Model;
import models.TexturedModel;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

import renderEngine.Loader;
import renderEngine.MainRendererHandler;
import renderEngine.OBJLoader;
import engine.graphics.GuiRenderer;
import engine.graphics.GuiText;
import engine.graphics.GuiTexture;
import engine.graphics.buttons.AbstractButton;
import engine.graphics.buttons.ExitButton;
import engine.graphics.buttons.PauseButton;
import engine.graphics.fontmesh.SpecialTextObject;
import engine.graphics.fontmesh.TextHandler;
import engine.graphics.fontmesh.TextPositionObject;
import engine.graphics.particles.ParticleHandler;
import engine.graphics.particles.ParticleImage;
import engine.graphics.particles.ParticleSystem;
import engine.graphics.stateengine.IState;
import engine.graphics.stateengine.StateEngine;
import engine.graphics.textures.TerrainImage;
import engine.graphics.textures.TerrainPack;
import engine.graphics.textures.Texture;
import engine.graphics.water.WaterFrameBuffers;
import engine.graphics.water.WaterQuad;
import engine.graphics.water.WaterRenderer;
import engine.graphics.water.WaterShader;
import engine.world.Terrain;
import entities.Camera;
import entities.Entity;
import entities.Light;
import entities.Player;
import game.StaticVar;
import game.inentory.GuiStateEngine;
import game.inentory.PlayerInventory;

public class GameState implements IState{
	
	public static StateEngine guiRunner;
	
	StringBuilder textBuilder;
	
	Loader loader;
	MainRendererHandler renderer;
	
	//Water Rendering
	WaterFrameBuffers buffers = new WaterFrameBuffers();
	WaterShader waterShader = new WaterShader();
	WaterRenderer waterRenderer;

	// Lists
	List<Terrain> terrains = StaticVar.terrains;
	List<Entity> entities = StaticVar.entities;
	List<Entity> normalMapEntities = StaticVar.normalMapEntities;
	List<WaterQuad> waters = StaticVar.waters;
	List<Light> lights = StaticVar.lights;
	List<GuiTexture> guiTextures = StaticVar.guiTextures;
	
	WaterQuad water;
	Light sun;

	Player player;
	Camera camera;
	StateEngine engine;
	Terrain terrain;
	
	//Particle Information
	ParticleImage fireTexture;
	ParticleSystem fireSystem;
	Random random;
	
	GuiText xCoordDisplay;
	GuiText zCoordDisplay;
	GuiText yCoordDisplay;
	
	AbstractButton pauseButton;
	AbstractButton exitButton;
	GuiRenderer guiRenderer;
	GuiStateEngine inventoryHandler;
	
	GuiTexture player_sword;
	
	public GameState(Loader loader, MainRendererHandler renderer, StateEngine engine) {
		this.loader = loader;
		this.renderer = renderer;
		this.engine = engine;
		textBuilder = new StringBuilder("Hello world!");
		waterRenderer = new WaterRenderer(loader, waterShader, renderer.getProjectionMatrix(), buffers);
		random = new Random();
		inventoryHandler = new GuiStateEngine();
		Mouse.setGrabbed(true);
		guiRunner = new StateEngine();
		
		init();
	}
	
	public void init() {
		engine.stateMap.put(getID(), this);
		//GUI
		
		guiRenderer = new GuiRenderer(loader);
		pauseButton = new PauseButton(loader, "button2", new Vector2f(.10f, -.87f), new Vector2f(.06f, .06f));
		pauseButton.show(guiTextures);
		exitButton = new ExitButton(loader, "button2", new Vector2f(-.10f, -.87f), new Vector2f(0.06f, 0.06f));
		exitButton.show(guiTextures);
		
		//Player inventory
		GuiTexture player_inventory = new GuiTexture(loader.loadTexture("guis/player_inventory"), 
				new Vector2f(.3477f, -.3f), 
				new Vector2f(.97f, 1f));
		inventoryHandler.guis.put(1, new PlayerInventory(new Vector2f(1, 1),  5 , 5, player_inventory));
		player_sword = new GuiTexture(loader.loadTexture("items/sword"), 
				new Vector2f(.83f, -.51f), 
				new Vector2f(.75f, 6));
		//Text Stuff
		guiTextures.add(player_sword);
		SpecialTextObject sto1 = new SpecialTextObject(new Vector3f(1, 1, 1), new Vector3f(0, 0, 0), .1f, new Vector2f(0,-0.006f), true);
		
		//Top text in the game state
		new GuiText("Callie is annoying", TextHandler.invFont, sto1, new TextPositionObject(3f, new Vector2f(0, .8f), 1, true), StateEngine.GameState);
		
		ParticleHandler.init(loader, renderer.getProjectionMatrix());
		fireTexture = new ParticleImage(loader.loadTexture("fire"), 8);
			fireTexture.setAdditive(false);
			fireSystem = new ParticleSystem(fireTexture, 1000, 5, .04f, 5, 2);
		TerrainImage backgroundTexture = new TerrainImage(loader.loadTexture("Grass"));
			TerrainImage rTexture = new TerrainImage(loader.loadTexture("Grass"));
			TerrainImage gTexture = new TerrainImage(loader.loadTexture("Grass"));
			TerrainImage bTexture = new TerrainImage(loader.loadTexture("path"));
			TerrainPack texturePack = new TerrainPack(backgroundTexture, rTexture,
				gTexture, bTexture);
			TerrainImage blendMap = new TerrainImage(loader.loadTexture("blendMap"));
			terrain = new Terrain(0, -1, loader, texturePack, blendMap, "heightmap");
		
		player = new Player(null, new Vector3f(100, 5, -100), 0, 0, 0, 0.6f);
		camera = new Camera(player);
		sun = new Light(new Vector3f(1, 1000000, -1000000), new Vector3f(2f, 2f, 2f));
		water = new WaterQuad(100, -100, terrain.getHeightOfTerrain(100, -100));
		terrains.add(terrain);
		lights.add(sun);
		entities.add(player);
		System.out.println(getID() + " state has been initialized");
	}

	@Override
	public void postProcess() {
		
	}

	@Override
	public void update() {
		
		pauseButton.update();
		exitButton.update();
		while (Keyboard.next()) {
			if (Keyboard.getEventKeyState()) {
				if (Keyboard.getEventKey() == Keyboard.KEY_RCONTROL) {
					if (Mouse.isGrabbed()) {
						Mouse.setGrabbed(false);
					} else if (!Mouse.isGrabbed()) {
						Mouse.setGrabbed(true);
					}
				} else if (Keyboard.getEventKey() == Keyboard.KEY_E) {
					if (inventoryHandler.current != 0) {
						inventoryHandler.changeGui(0);
						Mouse.setGrabbed(true);
							
					} else {
						Mouse.setGrabbed(false);
						inventoryHandler.changeGui(1);
					}
				}
			}
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_V)) {
			GL11.glPolygonMode( GL11.GL_FRONT_AND_BACK, GL11.GL_LINE );
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_B)) {
			GL11.glPolygonMode( GL11.GL_FRONT_AND_BACK, GL11.GL_FILL);
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_P))
			engine.changeState(StateEngine.PauseState);
		
		ParticleHandler.update(camera);
	}
	
	@Override
	public void render() {
		player_sword.setPosition(new Vector2f(.77f, 0.12f));
		player_sword.setScale(new Vector2f(.2f, 2.4f));
		player.move(terrain);
		camera.move();
		GL11.glEnable(GL30.GL_CLIP_DISTANCE0);
		
		//render reflection texture
		buffers.bindReflectionFrameBuffer();
		float distance = 2 * (camera.getPosition().y - water.getHeight());
		camera.getPosition().y -= distance;
			camera.invertPitch();
				renderer.renderScene(entities, normalMapEntities, terrains, lights, camera, new Vector4f(0, 1, 0, -water.getHeight()+1));
			camera.getPosition().y += distance;
		camera.invertPitch();
		
		//render refraction texture
		buffers.bindRefractionFrameBuffer();
		renderer.renderScene(entities, normalMapEntities, terrains, lights, camera, new Vector4f(0, -1, 0, water.getHeight()));
		
		//render to screen
		GL11.glDisable(GL30.GL_CLIP_DISTANCE0);
		buffers.unbindCurrentFrameBuffer();	
		renderer.renderScene(entities, normalMapEntities, terrains, lights, camera, new Vector4f(0, -1, 0, 100000));	
		waterRenderer.render(waters, camera, sun);
		ParticleHandler.renderParticles(camera);
		guiRenderer.render(guiTextures);
		inventoryHandler.renderGui(guiRenderer);
		TextHandler.render();
	}
	
	public void cleanUp() {
		TextHandler.cleanUp();
		buffers.cleanUp();
		waterShader.cleanUp();
		guiRenderer.cleanUp();
		renderer.cleanUp();
		loader.cleanUp();
	}
	
	@Override
	public int getID() {
		return StateEngine.GameState;
	}

}
