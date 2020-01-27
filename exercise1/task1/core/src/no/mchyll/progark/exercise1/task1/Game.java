package no.mchyll.progark.exercise1.task1;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {
	private SpriteBatch batch;
	private Helicopter helicopter;
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		helicopter = new Helicopter(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		helicopter.update();

		batch.begin();
		batch.draw(helicopter.sprite, helicopter.position.x, helicopter.position.y);
		batch.end();
	}
	
	@Override
	public void dispose() {
		batch.dispose();
		helicopter.texture.dispose();
	}
}
