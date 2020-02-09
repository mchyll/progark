package no.mchyll.progark.exercise2.pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Game implements the Singleton pattern.
 */
public class Game extends ApplicationAdapter {
	private int width;
	private int height;
	private SpriteBatch batch;
	private GameStateManager gameStateManager;

	// Game is a singleton, this is the only instance of it
	private static final Game INSTANCE = new Game();
	private Game() { }

	/**
	 * Get the singleton instance of Game.
	 * @return the singleton Game object
	 */
	public static Game getInstance() {
		return INSTANCE;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public void create() {
		width = Gdx.graphics.getWidth() - 30;
		height = Gdx.graphics.getHeight() - 30;
		batch = new SpriteBatch();
		gameStateManager = GameStateManager.getInstance();
		gameStateManager.setState(new PlayState());
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gameStateManager.update(Gdx.graphics.getDeltaTime());
		gameStateManager.render(batch);
	}
	
	@Override
	public void dispose() {
		batch.dispose();
	}
}
