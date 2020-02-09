package no.mchyll.progark.exercise2.pong;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

abstract class State {
    public abstract void update(float deltaTime);

    public abstract void render(SpriteBatch spriteBatch);
}
