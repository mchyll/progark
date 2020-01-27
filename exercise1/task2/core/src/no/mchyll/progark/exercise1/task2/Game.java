package no.mchyll.progark.exercise1.task2;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {
	private int screenWidth, screenHeight;
	private Helicopter helicopter;
	private SpriteBatch batch;
	private BitmapFont font;

	@Override
	public void create() {
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();

		batch = new SpriteBatch();
		helicopter = new Helicopter(screenWidth, screenHeight);
		font = new BitmapFont();

		Gdx.gl.glClearColor(0, 0, 0, 1);
	}

	private void handleInput() {
		if (Gdx.input.justTouched()) {
			int x = Gdx.input.getX();
			int y = screenHeight - Gdx.input.getY();
			helicopter.setDestinationPoint(x, y);
		}
	}

	@Override
	public void render() {
		handleInput();
		helicopter.update();

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(helicopter.sprite, helicopter.position.x, helicopter.position.y);
		font.draw(batch, "x: " + helicopter.position.x + ", y: " + helicopter.position.y, 10, screenHeight - 10);
		batch.end();
	}
	
	@Override
	public void dispose() {
		batch.dispose();
		helicopter.texture.dispose();
	}
}
