package com.andika.frontend.obstacles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
<<<<<<< HEAD
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class BaseObstacle {
    protected Vector2 position;
    protected Rectangle collider;
    protected float length;
    protected final float WIDTH = 10;
    protected boolean active = false;

    public BaseObstacle(Vector2 startPosition, int length) {
        this.position = new Vector2(startPosition);
        this.length = length;
        updateCollider();
    }

    public void initialize(Vector2 startPosition, int length) {
        this.position.set(startPosition);
        this.length = length;
        updateCollider();
    }

    public void render(ShapeRenderer shapeRenderer) {
        if (!active) return;
        drawShape(shapeRenderer);
    }

    public boolean isColliding(Rectangle playerCollider) {
        return active && collider.overlaps(playerCollider);
    }

    // Check if obstacle is behind the camera (off-screen to the left)
    public boolean isOffScreenCamera(float cameraLeftEdge) {
        return position.x + getRenderWidth() < cameraLeftEdge - 100; // Buffer behind camera
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setPosition(float x, float y) {
        position.set(x, y);
        updateCollider();
    }

    public Vector2 getPosition() {
        return position;
    }

    protected abstract void updateCollider(); // Abstract method for specific collider update

    protected abstract void drawShape(ShapeRenderer shapeRenderer); // Abstract method for specific drawing

    protected abstract float getRenderWidth(); // Abstract method for specific render width
}
=======
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


>>>>>>> 14a32b6e44e77ede470b1b3f394bf224a4bc0561
