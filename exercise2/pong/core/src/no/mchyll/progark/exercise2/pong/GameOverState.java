package no.mchyll.progark.exercise2.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOverState extends State {

    private String text;
    private BitmapFont font;

    public GameOverState(String text) {
        this.text = text;
        font = new BitmapFont();
        font.setColor(Color.WHITE);
//        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
//        font.getData().setScale(2);
    }

    @Override
    public void update(float deltaTime) {
        if (Gdx.input.justTouched()) {
            GameStateManager.getInstance().setState(new PlayState());
        }
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        font.draw(spriteBatch, text,
                Game.getInstance().getWidth() / 2 - 50,
                Game.getInstance().getHeight() / 2);
        spriteBatch.end();
    }
}
