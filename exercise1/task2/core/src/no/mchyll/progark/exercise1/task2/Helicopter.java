package no.mchyll.progark.exercise1.task2;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Helicopter {
    public Vector2 position;
    public Vector2 destination;

    public Texture texture;
    public Sprite sprite;

    private int width;
    private int height;
    private int screenWidth;
    private int screenHeight;

    public Helicopter(int screenWidth, int screenHeight) {
        texture = new Texture("attackhelicopter.PNG");
        sprite = new Sprite(texture);

        position = new Vector2(50, 50);
        destination = new Vector2(50, 50);

        this.width = texture.getWidth();
        this.height = texture.getHeight();
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }

    public void setDestinationPoint(int x, int y) {
        destination.x = x;
        destination.y = y;
        sprite.setFlip(position.x - destination.x < 0, false);
    }

    public void update() {
        float dx = position.x - destination.x;
        float dy = position.y - destination.y;

        if (dx < 0 && position.x < screenWidth - width) {
            position.x++;
        }
        else if (dx > 0 && position.x > 0) {
            position.x--;
        }
        if (dy < 0 && position.y < screenHeight - height) {
            position.y++;
        }
        else if (dy > 0 && position.y > 0) {
            position.y--;
        }
    }
}
