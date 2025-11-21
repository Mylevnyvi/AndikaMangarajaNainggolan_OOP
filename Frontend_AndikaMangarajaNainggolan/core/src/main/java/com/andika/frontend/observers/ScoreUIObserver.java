package com.andika.frontend.observers;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Color;

public class ScoreUIObserver implements Observer {

    private BitmapFont font;
    private SpriteBatch batch;

    public ScoreUIObserver() {
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        batch = new SpriteBatch();
    }

    @Override
    public void update(int score) {
        System.out.println("Score updated to: " + score);
    }

    public void render(int score) {
        batch.begin();
        font.draw(batch, "Score: " + score, 20, 460);
        batch.end();
    }

    public void dispose() {
        font.dispose();
        batch.dispose();
    }
}
