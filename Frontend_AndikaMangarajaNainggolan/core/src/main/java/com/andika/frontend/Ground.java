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
        float width = Gdx.graphics.getWidth();
        collider = new Rectangle(0, 0, 0, GROUND_HEIGHT);
    }

    public void update(float cameraX) {

    }
}
