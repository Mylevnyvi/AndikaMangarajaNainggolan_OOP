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

public class GameManager {
    private static GameManager instance;
    private int score;
    private boolean gameActive;

    private GameManager() {
        score = 0;
        gameActive = false;
    }

    public static GameManager getInstance() {
        if(instance == null) instance = new GameManager();
        return instance;
    }

}
