package no.mchyll.progark.exercise1.task4.sprites;

import no.mchyll.progark.exercise1.task4.Game;

public class PaddleComputer extends Paddle {

    private Ball ball;

    public PaddleComputer(int xPos, int yPos, Ball ball) {
        super(xPos - 37, yPos);
        this.ball = ball;
    }

    @Override
    public void movePaddle() {
        float dy = position.y - ball.getPosition().y;

        // Only move when ball is on CPU's side
        if (ball.getPosition().x >= Game.WIDTH / 2) {
            // Up
            if (dy < -2 && position.y < Game.HEIGHT - ROOF_MARGIN) {
                position.y += 3;
            }
            // Down
            if (dy > 2 && position.y > 0) {
                position.y -= 3;
            }
        }
    }
}
