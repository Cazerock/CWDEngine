package models;

import engine.graphics.textures.Texture;

public class TexturedModel {
	
	private Model model;
	private Texture texture;

	public TexturedModel(Model model, Texture texture){
		this.model = model;
		this.texture = texture;
	}

	public Model getModel() {
		return model;
	}

	public Texture getTexture() {
		return texture;
	}
	
	
}
