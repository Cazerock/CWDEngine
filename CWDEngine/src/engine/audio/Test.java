package engine.audio;

import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		AudioHandler.init();
		AudioHandler.setListenerData();
		
		int buffer = AudioHandler.loadSound("audio/laser.wav");
		Source source = new Source();
		
		char c = ' ';
		while (c != 'q') {
			c = (char)System.in.read();
			
			if (c == 'p') {
				source.play(buffer);
			}
		}
		
		source.delete();
		AudioHandler.cleanUp();
	}

}
