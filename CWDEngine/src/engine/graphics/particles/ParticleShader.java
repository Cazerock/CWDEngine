package engine.graphics.particles;

import org.lwjgl.util.vector.Matrix4f;

import engine.graphics.shaders.ShaderProgram;

public class ParticleShader extends ShaderProgram {

	private static final String VERTEX_FILE = "src/shaders/particleVShader.txt";
	private static final String FRAGMENT_FILE = "src/shaders/particleFShader.txt";

	private int location_projectionMatrix;
	private int location_numberOfRows;
	
	public ParticleShader() {
		super(VERTEX_FILE, FRAGMENT_FILE);
	}

	@Override
	protected void getAllUniformLocations() {
		location_numberOfRows = super.getUniformLocation("numberOfRows");
		location_projectionMatrix = super.getUniformLocation("projectionMatrix");
		
	}
	
	//Number of rows in the atlas
	protected void loadNumberOfRows(float numberOfRows) {
		super.loadFloat(location_numberOfRows, numberOfRows);
	}
	
	//Creates the view of the particles correctly
	protected void loadProjectionMatrix(Matrix4f projectionMatrix) {
		super.loadMatrix(location_projectionMatrix, projectionMatrix);
	}
	
	@Override
	protected void bindAttributes() {
		super.bindAttribute(0, "position");
		super.bindAttribute(1, "modelViewMatrix");
		super.bindAttribute(5, "texOffsets");
		super.bindAttribute(6, "blendFactor");
	}


}
