package no.mchyll.progark.exercise2.pong;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Global handling of game states, e.g. playing or game over.
 * GameStateManager implements both the Singleton and State patterns.
 */
public class GameStateManager {

    private static final GameStateManager INSTANCE = new GameStateManager();
    private State currentState;

    // GameStateManager is a singleton, so nobody else can create instances of it
    private GameStateManager() {
        currentState = null;
    }

    /**
     * Get the singleton instance of GameStateManager.
     * @return the singleton GameStateManager object
     */
    public static GameStateManager getInstance() {
        return INSTANCE;
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public void update(float deltaTime) {
        currentState.update(deltaTime);
    }

    public void render(SpriteBatch spriteBatch) {
        currentState.render(spriteBatch);
    }
}
