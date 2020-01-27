package no.mchyll.progark.exercise1.task3;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Helicopter {
    public static final int WIDTH = HelicopterAnimation.WIDTH;
    public static final int HEIGHT = HelicopterAnimation.HEIGHT;

    public Vector2 position;
    private Vector2 velocity;
    private HelicopterAnimation animation;
    private Rectangle bounds;

    private int screenWidth;
    private int screenHeight;

    public Helicopter(int x, int y, int screenWidth, int screenHeight) {

        animation = new HelicopterAnimation();
        velocity = new Vector2((float) Math.random() + 0.5f, (float) Math.random() + 0.5f);
        animation.setFlip(velocity.x >= 0);

        position = new Vector2(x, y);

        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;

        bounds = new Rectangle(position.x, position.y, WIDTH, HEIGHT);
    }

    public Sprite getSprite() {
        return animation.getFrame();
    }

    public void update(float dt) {
        animation.update(dt);
        position.add(velocity);

        if (position.y + HEIGHT >= screenHeight || position.y <= 0) {
            velocity.y *= -1;
        }
        if (position.x + WIDTH >= screenWidth || position.x <= 0) {
            velocity.x *= -1;
            animation.setFlip(velocity.x >= 0);
        }

        bounds.setPosition(position.x, position.y);
    }

    public void flipXDir() {
        velocity.x *= -1;
        animation.setFlip(velocity.x >= 0);
    }

    public void flipYDir() {
        velocity.y *= -1;
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
