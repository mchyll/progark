package no.mchyll.progark.exercise2.pong;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Part of the State design pattern.
 * Abstract class defining the common interface for the different game states.
 */
public abstract class State {
    public abstract void update(float deltaTime);

    public abstract void render(SpriteBatch spriteBatch);
}
