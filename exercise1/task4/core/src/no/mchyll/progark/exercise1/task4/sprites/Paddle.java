package no.mchyll.progark.exercise1.task4.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public abstract class Paddle {
    protected Texture texture;
    protected Vector3 position;
    protected Rectangle rectangle;
    protected int paddleResize = 4;
    protected final static int ROOF_MARGIN = 80;

    public Paddle(int xPos, int yPos) {
        texture = new Texture("paddle.jpg");
        position = new Vector3(xPos, yPos, 0);
        rectangle = new Rectangle(xPos, yPos,
                texture.getWidth() / paddleResize, texture.getHeight()/paddleResize);
    }

    public void handleInput() {
        movePaddle();
        rectangle.setPosition(position.x, position.y);
    }

    public abstract void movePaddle();

    public boolean didBallCollide(Rectangle ballRectangle) {
        return ballRectangle.overlaps(this.rectangle);
    }

    public Texture getTexture() {
        return texture;
    }

    public Vector3 getPosition() {
        return position;
    }

    public int getPaddleResize() {
        return paddleResize;
    }
}
