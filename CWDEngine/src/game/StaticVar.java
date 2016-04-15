package game;

import java.util.ArrayList;
import java.util.List;

import engine.graphics.GuiTexture;
import engine.graphics.water.WaterQuad;
import engine.world.Terrain;
import entities.Entity;
import entities.Light;

public class StaticVar {

	public static List<GuiTexture> guiTextures;
	public static List<Light> lights;
	public static List<WaterQuad> waters;
	public static List<Terrain> terrains;
	public static List<Entity> entities;
	public static List<Entity> normalMapEntities;

	public static void init() {
		terrains = new ArrayList<Terrain>();
		entities = new ArrayList<Entity>();
		normalMapEntities = new ArrayList<Entity>();
		waters = new ArrayList<WaterQuad>();
		lights = new ArrayList<Light>();
		guiTextures = new ArrayList<GuiTexture>();
}
	
}
