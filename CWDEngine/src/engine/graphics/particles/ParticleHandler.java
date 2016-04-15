package engine.graphics.particles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.lwjgl.util.vector.Matrix4f;

import renderEngine.Loader;
import entities.Camera;

public class ParticleHandler {
	
	private static Map<ParticleImage, List<Particle>> particles = new HashMap<ParticleImage, List<Particle>>();
	private static ParticleRenderer renderer;
	
	public static void init(Loader loader, Matrix4f projectionMatrix) {
		renderer = new ParticleRenderer(loader, projectionMatrix);
	}
	
	public static void update(Camera camera) {
		Iterator<Entry<ParticleImage, List<Particle>>> mapInterator = particles.entrySet().iterator(); 
		while (mapInterator.hasNext()) {
			List<Particle> list = mapInterator.next().getValue();
			Iterator<Particle> iterator = list.iterator();
			
			while (iterator.hasNext()) {
				Particle p = iterator.next();
				boolean stillAlive = p.update(camera);
				if (!stillAlive) {
					iterator.remove();
					if (list.isEmpty()) {
						mapInterator.remove();
					}
				}
			}
			InsertionSort.sortHighToLow(list);
		}
		
	}
	
	public static void renderParticles(Camera camera) {
		renderer.render(particles, camera);
	}
	
	public static void cleanUp() {
		renderer.cleanUp();
	}
	
	public static void addParticle(Particle part) {
		List<Particle> list = particles.get(part.getTexture());
		if (list == null) {
			list = new ArrayList<Particle>() ;
			particles.put(part.getTexture(), list);
		}
		list.add(part);
	}
	
}
