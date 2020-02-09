package no.mchyll.progark.exercise2.pong;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import no.mchyll.progark.exercise2.pong.sprites.Ball;
import no.mchyll.progark.exercise2.pong.sprites.PaddlePlayer;
import no.mchyll.progark.exercise2.pong.sprites.PaddleComputer;

public class PlayState {
    private static final int WINNING_SCORE = 21;

    private Ball ball;
    private PaddlePlayer paddle1;
    private PaddleComputer paddle2;

    private int score1 = 0;
    private int score2 = 0;

    private BitmapFont bitmapFont;

    private String winnerString = "";
    private boolean gameFinished = false;

    public PlayState() {
        ball = new Ball();
        paddle1 = new PaddlePlayer(0, Game.HEIGHT/2);
        paddle2 = new PaddleComputer(Game.WIDTH, Game.HEIGHT/2, ball);

        bitmapFont = new BitmapFont();
        bitmapFont.setColor(Color.WHITE);
    }

    public void handleInput() {
        paddle1.handleInput();
        paddle2.handleInput();
    }

    public void update(float deltaTime) {
        handleInput();
        ball.update(deltaTime);
        handlePotentialCollision();
        if (gameFinished) return;

        if (ball.getPosition().x <= 0) {
            score2++;
            ball.reset();
        }
        if (ball.getPosition().x >= Game.WIDTH) {
            score1++;
            ball.reset();
        }

        if (score1 >= WINNING_SCORE) {
            winnerString = "Player wins the game!";
            gameFinished = true;
        }
        if (score2 >= WINNING_SCORE) {
            winnerString = "Computer wins the game!";
            gameFinished = true;
        }
    }

    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.draw(ball.getTexture(), ball.getPosition().x, ball.getPosition().y, 30, 30);
        spriteBatch.draw(paddle1.getTexture(),
                paddle1.getPosition().x,
                paddle1.getPosition().y,
                paddle1.getTexture().getWidth() / paddle1.getPaddleResize(),
                paddle1.getTexture().getHeight() / paddle1.getPaddleResize());

        spriteBatch.draw(paddle2.getTexture(),
                paddle2.getPosition().x,
                paddle2.getPosition().y,
                paddle2.getTexture().getWidth() / paddle2.getPaddleResize(),
                paddle2.getTexture().getHeight() / paddle2.getPaddleResize());

        bitmapFont.draw(spriteBatch,
                "" + score1,
                5,
                Game.HEIGHT - 5);

        bitmapFont.draw(spriteBatch,
                "" + score2,
                Game.WIDTH - 5,
                Game.HEIGHT - 5);

        bitmapFont.draw(spriteBatch,
                winnerString,
                Game.WIDTH/2 - 50,
                Game.HEIGHT/2);

        spriteBatch.end();
    }

    private void handlePotentialCollision() {
        if (paddle1.didBallCollide(ball.getRectangle()) || paddle2.didBallCollide(ball.getRectangle())) {
            ball.bounceX();
        }
    }
}
