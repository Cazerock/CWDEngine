package engine.graphics.fontmesh;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import renderEngine.Loader;
import engine.graphics.FontRenderer;
import engine.graphics.FontType;
import engine.graphics.GuiText;

public class TextHandler {
	
	public static boolean SpecialText = false;
	private static Loader loader;
	private static Map<FontType, List<GuiText>> texts = new HashMap<FontType, List<GuiText>>();
	private static FontRenderer renderer;
	public static FontType invFont;
	
	public static void init(Loader theLoader){
//		renderer = new FontRenderer();
//		loader = theLoader;
//		invFont = new FontType(loader.loadTexture("fonts/bitmap"), new File("res/fonts/bitmap.fnt"));
	}
	
	public static void render(){
//		renderer.render(texts);
	}
	
	public static void loadText(GuiText text){
//		FontType font = text.getFont();
//		TextMeshData data = font.loadText(text);
//		int vao = loader.loadToVAO(data.getVertexPositions(), data.getTextureCoords());
//		text.setMeshInfo(vao, data.getVertexCount());
//		List<GuiText> textBatch = texts.get(font);
//		if(textBatch == null){
//			textBatch = new ArrayList<GuiText>();
//			texts.put(font, textBatch);
//		}
//		textBatch.add(text);
	}
	
	public static void removeText(GuiText text){
//		List<GuiText> textBatch = texts.get(text.getFont());
//		textBatch.remove(text);
//		if(textBatch.isEmpty()){
//			texts.remove(texts.get(text.getFont()));
//		}
	}
	
	public static void cleanUp(){
//		renderer.cleanUp();
	}

}
