package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.util.vector.Vector2f;

public class DisplayManager {
	
	private static final int WIDTH = 854;
	private static final int HEIGHT = 480;
	private static final int FPS_CAP = 60;
	
	private static long lastFrameTime;
	private static float delta;
	
	public static void createDisplay(){		
		//Version of open GL
		ContextAttribs attribs = new ContextAttribs(3, 3)
		.withForwardCompatible(true)
		.withProfileCore(true);
		
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT));
			Display.create(new PixelFormat().withSamples(8).withDepthBits(24), attribs);
			Display.setResizable(true);
			Display.setVSyncEnabled(true);
			
			Display.setTitle("Clock work days [powered by friction and depression]");
			GL11.glEnable(GL13.GL_MULTISAMPLE);
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		GL11.glViewport(0,0, WIDTH, HEIGHT);
		lastFrameTime = getCurrentTime();
	}
	
	public static void updateDisplay(){
		Display.sync(FPS_CAP);
		Display.update();
		long currentFrameTime = getCurrentTime();
		delta = (currentFrameTime - lastFrameTime)/1000f;
		lastFrameTime = currentFrameTime;
	}
	
	public static float getFrameTimeSeconds(){
		return delta;
	}
	
	public static void closeDisplay(){
		Display.destroy();
	}
	
	private static long getCurrentTime(){
		return Sys.getTime()*1000/Sys.getTimerResolution();
	}
	
	public static Vector2f getNormalizedMouseCoord() {
		float normX = -1.0f + 2.0f * (float) Mouse.getX() / (float) Display.getWidth();
		float normY = 1.0f - 2.0f * (float) Mouse.getY() / (float) Display.getHeight();
		return new Vector2f(normX, normY);
		
	}
	

}
