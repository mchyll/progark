package no.mchyll.progark.exercise1.task3;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;

public class HelicopterAnimation {
    public static final int WIDTH = 162;
    public static final int HEIGHT = 65;

    private ArrayList<Sprite> frames;
    private int currentFrame;
    private float currentFrameTime;

    public HelicopterAnimation() {
        frames = new ArrayList<>();
        frames.add(new Sprite(new Texture("heli1.png")));
        frames.add(new Sprite(new Texture("heli2.png")));
        frames.add(new Sprite(new Texture("heli3.png")));
        frames.add(new Sprite(new Texture("heli4.png")));
    }

    public void update(float dt) {
        currentFrameTime += dt;
        if (currentFrameTime > 0.1f) {
            if (++currentFrame >= frames.size()) {
                currentFrame = 0;
            }
            currentFrameTime = 0;
        }
    }

    public Sprite getFrame() {
        return frames.get(currentFrame);
    }

    public void setFlip(boolean b) {
        for (Sprite s : frames) {
            s.setFlip(b, false);
        }
    }
}
