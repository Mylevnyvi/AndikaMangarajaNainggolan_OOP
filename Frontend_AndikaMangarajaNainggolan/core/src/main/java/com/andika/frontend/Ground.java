package com.andika.frontend;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.math.Rectangle;


public class Ground {
    private static final float GROUND_HEIGHT = 50f;

    public Rectangle collider;

    public  Ground(){
        float width = Gdx.graphics.getWidth() * 2f;
        collider = new Rectangle(0, 0, 0, GROUND_HEIGHT);
    }

    public void update(float cameraX) {
        float x = cameraX - Gdx.graphics.getWidth() / 2f - 500f;
        float width = Gdx.graphics.getWidth() + 1000f;
        collider.set(x, 0f, width, GROUND_HEIGHT);
    }
    public boolean isColliding(Rectangle playerCollider) {
        return collider.overlaps(playerCollider);
    }
    public float getTopY() {
        return GROUND_HEIGHT;
    }

    public void renderShape(ShapeRenderer shaperenderer) {
        shaperenderer.setColor(0.5f, 0.5f, 0.5f, 1f);
        shaperenderer.rect(collider.x, collider.y, collider.width, collider.height);
    }
}
