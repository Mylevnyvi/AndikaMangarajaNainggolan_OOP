package com.andika.frontend;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Square extends Shape {
    public Square() {
        this.type = "Square";
    }

    @Override
    public void render(ShapeRenderer renderer) {
        renderer.rect(position.x - size / 2, position.y - size / 2, size, size);
    }
}

