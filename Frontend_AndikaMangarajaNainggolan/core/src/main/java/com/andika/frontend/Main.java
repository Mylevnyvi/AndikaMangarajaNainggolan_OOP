package com.andika.frontend;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */

    public class Main extends ApplicationAdapter {
        private ShapeRenderer shapeRenderer;
        private Player player;
        private Ground ground;
        private GameManager gameManager;

        private OrthographicCamera camera;
        private float cameraOffset = 0.2f;


    @Override
    public void create(){
        shapeRenderer = new ShapeRenderer();
        gameManager = GameManager.getInstance();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.setToOrtho(false);
        player = new Player(new Vector2(100f,Gdx.graphics.getHeight()/2f));
        ground = new Ground();
        gameManager.startGame();
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();


        update(delta);

        ScreenUtils.clear(0.1f, 0.12f, 0.16f, 1f);

        shapeRenderer.setProjectionMatrix(camera.combined);

       shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
       ground.renderShape(shapeRenderer);
       player.renderShape(shapeRenderer);
       shapeRenderer.end();
    }

    private void updateCamera(float delta){
        float cameraFocus = player.getPosition().x + player.getWidth() * cameraOffset;
        camera.position.x = cameraFocus;
        camera.update();

    }

    private void update(float delta) {
    boolean isFlying = Gdx.input.isKeyJustPressed(Input.Keys.SPACE);



    player.update(delta, isFlying);
    camera.update();
    updateCamera(camera.position.x);
    player.checkBoundaries(ground, Gdx.graphics.getHeight());

    int newScore = (int) player.getDistanceTraveled();
    if (newScore != gameManager.getScore()) {
        gameManager.setScore(newScore);
        System.out.println("Score: " + gameManager.getScore());
    }
    }

    @Override
    public void dispose() {
        if (shapeRenderer != null) shapeRenderer.dispose();
    }
    }
