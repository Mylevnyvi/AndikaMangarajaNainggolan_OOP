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

public class Player {
    private Vector2 position;
    private Vector2 velocity;

    private float gravity = 2000f;
    private float force = 4500f;
    private float maxVerticalSpeed = 700f;
    private Rectangle collider;
    private float width = 64f;
    private float height = 64f;
    private float baseSpeed = 300f;
    private float distanceTraveled = 0f;

    public Player(Vector2 startPosition) {
        this.position = new Vector2(startPosition);
        this.velocity = new Vector2(baseSpeed, 0f);
        this.collider = new Rectangle(position.x, position.y, width, height);
    }

    public Vector2 getPosition() {return position;}
    public Rectangle getCollider() {return collider;}

    private void updateDistanceAndSpeed(float delta) {
        distanceTraveled += velocity.x * delta;
    }

     private void updateCollider() {
        collider.set(position.x, position.y, width, height);
     }

     public float getWidth() {return width;}
     public float getHeight() {return height;}

    private void fly(float delta) {
        velocity.y += force * delta;
    }

    private void updatePosition(float delta) {
        position.x += velocity.x * delta;
        position.y += velocity.y * delta;
    }

    private void applyGravity(float delta) {
        velocity.y -= gravity * delta;
        velocity.x = baseSpeed;
        if (velocity.y > maxVerticalSpeed) velocity.y = maxVerticalSpeed;
        if (velocity.y < -maxVerticalSpeed) velocity.y = -maxVerticalSpeed;
    }

    public void update(float delta, boolean isFlying) {
        updateDistanceAndSpeed(delta);
        applyGravity((delta));
        if (isFlying) {
        fly(delta);
    }
    updatePosition(delta);
        updateCollider();
    }

    public float getDistanceTraveled() {return distanceTraveled/10f;}

    public void checkBoundaries(Ground ground, float ceilingY) {

        if (ground.isColliding(collider)) {
            position.y = ground.getTopY();
            velocity.y = 0f;
            updateCollider();
        }

        if (position.y + height > ceilingY) {
            position.y = ceilingY - height;
            velocity.y = 0f;
            updateCollider();
        }

        if (position.y < 0f) {
            position.y = 0f;
            velocity.y = 0f;
            updateCollider();
        }
    }

    public void renderShape(ShapeRenderer shapeRenderer){
        shapeRenderer.setColor(2f, 0.8f, 0.6f, 0.4f);
        shapeRenderer.rect(position.x, position.y, width, height);
    }


}

