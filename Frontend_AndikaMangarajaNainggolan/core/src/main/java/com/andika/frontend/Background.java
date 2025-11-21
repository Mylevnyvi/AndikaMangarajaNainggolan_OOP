package com.andika.frontend;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.Gdx;

public class Background {

    private Texture backgroundTexture;
    private TextureRegion backgroundRegion;

    private float width, height;
    private float currentCameraX = 0f;

    public Background() {
        backgroundTexture = new Texture(Gdx.files.internal("background.png"));
        backgroundRegion = new TextureRegion(backgroundTexture);

        width = 2688f;
        height = 1536f;
    }

    public void update(float cameraX) {
        currentCameraX = cameraX;
    }

    public void render(SpriteBatch batch) {

        float screenW = Gdx.graphics.getWidth();
        float screenH = Gdx.graphics.getHeight();

        float scale = screenH / height;
        float scaledW = width * scale;
        float scaledH = height * scale;

        float startX = (float)Math.floor(currentCameraX / scaledW) * scaledW;

        for (float x = startX - scaledW; x <= startX + screenW + scaledW; x += scaledW) {
            batch.draw(backgroundRegion, x, 0, scaledW, scaledH);
        }
    }

    public void dispose() {
        if (backgroundTexture != null) backgroundTexture.dispose();
    }
}

