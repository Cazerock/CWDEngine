package entities;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import renderEngine.DisplayManager;

public class Camera {
	
	private float distanceFromPlayer = 0;
	
	private Vector3f position = new Vector3f(0, 0, 0);
	private float pitch = 0;
	private float yaw = 0;
	private float roll = 0;
	
	private float sensitivity = 25F;
	private float viewChange = 1.1F;
	private int offset = 15;

	private Player player;
	
	public Camera(Player player){
		this.player = player;	
	}
	
	public void move(){
		  calculateCameraPosition();
		  yaw = (float) (180 - player.getRotY());
		  mouse();	
	}
	
	public void mouse() {
		if (Mouse.isGrabbed()) {
		Mouse.setCursorPosition(Display.getWidth() / 2, Display.getHeight() / 2);
		player.increaseRotation(0, -Mouse.getDX() * sensitivity * DisplayManager.getFrameTimeSeconds(), 0);
		pitch -= Mouse.getDY() * sensitivity * DisplayManager.getFrameTimeSeconds();
		if (pitch > 90) pitch = 90;
		if (pitch < -90) pitch = -90;
		
		}
	}
	
	public void invertPitch(){
		this.pitch = -pitch;
	}

	public Vector3f getPosition() {
		return position;
	}

	public float getPitch() {
		return pitch;
	}

	public float getYaw() {
		return yaw;
	}

	public float getRoll() {
		return roll;
	}
	
	public void setPosition(Vector3f position) {
		this.position = position;
	}

	public void setPitch(float pitch) {
		this.pitch = pitch;
	}

	public void setYaw(float yaw) {
		this.yaw = yaw;
	}

	public void setRoll(float roll) {
		this.roll = roll;
	}
	
	 private void calculateCameraPosition()
	 {
	  position.x = player.getPosition().x;
	  position.z = player.getPosition().z;
	  position.y = player.getPosition().y + 10;
	 }

}
