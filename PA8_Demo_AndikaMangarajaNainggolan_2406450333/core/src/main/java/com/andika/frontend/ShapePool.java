package com.andika.frontend;

import java.util.ArrayList;

public class ShapePool {
    private ArrayList<Shape> circlePool = new ArrayList<>();
    private ArrayList<Shape> squarePool = new ArrayList<>();

    public Shape obtain(String type) {
        ArrayList<Shape> pool = getPool(type);
        if (!pool.isEmpty()) return pool.remove(0);
        return null;
    }

    public void release(Shape shape) {
        ArrayList<Shape> pool = getPool(shape.getType());
        if (pool.size() < 3) pool.add(shape);
    }

    public ArrayList<Shape> getPool(String type) {
        if (type.equalsIgnoreCase("Circle")) return circlePool;
        return squarePool;
    }
}
