package no.mchyll.progark.exercise1.task3;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class Game extends ApplicationAdapter {
	private SpriteBatch batch;

	private int screenWidth, screenHeight;
	private ArrayList<Helicopter> helicopters;
	
	@Override
	public void create() {
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();

		helicopters = new ArrayList<>();
		helicopters.add(new Helicopter(10, 10, screenWidth, screenHeight));
		helicopters.add(new Helicopter(screenWidth - Helicopter.WIDTH - 10, 10, screenWidth, screenHeight));
		helicopters.add(new Helicopter(screenWidth - Helicopter.WIDTH - 10, screenHeight - Helicopter.HEIGHT - 10, screenWidth, screenHeight));

		batch = new SpriteBatch();

		Gdx.gl.glClearColor(0, 0, 0, 1);
	}

	public void update(float dt) {
	    for (Helicopter helicopter : helicopters) {
		    helicopter.update(dt);
	    }

	    for (int i = 0; i < helicopters.size(); ++i) {
	        for (int j = i + 1; j < helicopters.size(); j++) {
	            Helicopter h1 = helicopters.get(i);
	            Helicopter h2 = helicopters.get(j);
	            if (h1.getBounds().overlaps(h2.getBounds())) {
                    h1.flipXDir();
                    h2.flipXDir();
                    h1.flipYDir();
                    h2.flipYDir();
                }
            }
        }
	}

	@Override
	public void render() {
		update(Gdx.graphics.getDeltaTime());

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		for (Helicopter helicopter : helicopters) {
    		batch.draw(helicopter.getSprite(), helicopter.position.x, helicopter.position.y);
        }
		batch.end();
	}
	
	@Override
	public void dispose() {
		batch.dispose();
	}
}
