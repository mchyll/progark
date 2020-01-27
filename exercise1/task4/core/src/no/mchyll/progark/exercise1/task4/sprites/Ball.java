package no.mchyll.progark.exercise1.task4.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import no.mchyll.progark.exercise1.task4.Game;

public class Ball {
    private final Vector3 START_POSITION = new Vector3(Game.WIDTH / 2, Game.HEIGHT / 2, 0);
    private final Vector3 START_VELOCITY = new Vector3(-5, 2, 0);

    private Texture texture;
    private Vector3 position;
    private Vector3 velocity;
    private Rectangle rectangle;
    private int resize = 30;

    public Ball() {
        texture = new Texture("ball.jpg");
        position = START_POSITION.cpy();
        velocity = START_VELOCITY.cpy();
        rectangle = new Rectangle(position.x, position.y,
                texture.getWidth() / resize, texture.getHeight() / resize);
    }

    public void update(float dt) {
        position.add(velocity.x, velocity.y, 0);
        rectangle.setPosition(position.x, position.y);
        if (shouldBounceY()) {
            bounceY();
        }
    }

    public void reset() {
        position = new Vector3(START_POSITION);
    }

    private void bounceY() {
        velocity.y = -velocity.y;
    }

    public void bounceX() {
        velocity.x = -velocity.x;
    }

    private boolean shouldBounceY() {
        return (position.y < 0 || position.y > Game.HEIGHT);
    }

    public Texture getTexture() {
        return texture;
    }

    public Vector3 getPosition() {
        return position;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
