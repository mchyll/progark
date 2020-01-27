package no.mchyll.progark.exercise1.task4;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {
	public static int WIDTH;
	public static int HEIGHT;

	private SpriteBatch batch;
	private PlayState playState;

	@Override
	public void create() {
		WIDTH = Gdx.graphics.getWidth() - 30;
		HEIGHT = Gdx.graphics.getHeight() - 30;
		batch = new SpriteBatch();
		playState = new PlayState();
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		playState.update(Gdx.graphics.getDeltaTime());
		playState.render(batch);
	}
	
	@Override
	public void dispose() {
		batch.dispose();
	}
}
