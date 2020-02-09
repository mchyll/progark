package no.mchyll.progark.exercise2.pong.sprites;

import com.badlogic.gdx.Gdx;

import no.mchyll.progark.exercise2.pong.Game;

public class PaddlePlayer extends Paddle {

    public PaddlePlayer(int xPos, int yPos) {
        super(xPos, yPos);
    }

    @Override
    public void movePaddle() {
        float dy = position.y - (Game.getInstance().getHeight() - Gdx.input.getY());

        // Up
        if (dy < -3 && position.y < Game.getInstance().getHeight() - ROOF_MARGIN) {
            position.y += 5;
        }
        // Down
        if (dy > 3 && position.y > 0) {
            position.y -= 5;
        }
    }
}
