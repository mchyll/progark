package no.mchyll.progark.exercise1.task1;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Helicopter {
    public Vector2 velocity;
    public Vector2 position;

    public Texture texture;
    public Sprite sprite;

    private int width;
    private int height;
    private int screenWidth;
    private int screenHeight;

    public Helicopter(int screenWidth, int screenHeight) {
        texture = new Texture("attackhelicopter.PNG");
        sprite = new Sprite(texture);

        velocity = new Vector2(1.1f, 0.8f);
        position = new Vector2();

        this.width = texture.getWidth();
        this.height = texture.getHeight();
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;

        sprite.setFlip(velocity.x >= 0, false);
    }

    public void update() {
        position.add(velocity);

        if (position.y + height >= screenHeight || position.y <= 0) {
            velocity.y *= -1;
        }
        if (position.x + width >= screenWidth || position.x <= 0) {
            velocity.x *= -1;
            sprite.flip(true, false);
        }
    }
}
