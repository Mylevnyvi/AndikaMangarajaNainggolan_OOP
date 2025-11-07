package com.andika.frontend.obstacles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Rectangle;

public abstract class BaseObstacle {
    private Vector2 position;
    private Rectangle collider;
    private float length;
    private final float width = 10f;
    Boolean active = false;

    public BaseObstacle(Vector2 startPosition, int length){
        position = new Vector2(startPosition);
        collider = new Rectangle(position.x, position.y, width, length);
    }
    private void updateCollider() {
        collider.set(position.x, position.y, width, length);
    }

    public void initialize(Vector2 startPosition) {
        position = new Vector2(0, 0);
        updateCollider();
    }

    public boolean isColliding(Rectangle playerCollider) {
        return collider.overlaps(playerCollider);
    }


    public void renderShape(ShapeRenderer shapeRenderer){
        shapeRenderer.setColor(2f, 0.8f, 0.6f, 0.4f);
        shapeRenderer.rect(position.x, position.y, width, length);
    }

    public void render(ShapeRenderer shaperenderer) {

    }
}


