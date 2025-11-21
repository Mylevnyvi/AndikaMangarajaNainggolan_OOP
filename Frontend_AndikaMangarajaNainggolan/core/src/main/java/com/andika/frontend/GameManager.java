package com.andika.frontend;


import com.andika.frontend.observers.Observer;
import com.andika.frontend.observers.ScoreManager;

public class GameManager {
    private static GameManager instance;
    private int score;
    private ScoreManager scoreManager;
    private boolean gameActive;

    private GameManager() {
        score = 0;
        gameActive = false;
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void startGame() {
        score = 0;
        gameActive = true;
        System.out.println("Game Started!");
    }

    public void setScore(int s) {
        scoreManager.setScore(s);
    }

    public int getScore() {
        return scoreManager.getScore();
    }

    public void addObserver(Observer obs) {
        scoreManager.addObserver(obs);
    }

    public void removeObserver(Observer obs) {
        scoreManager.removeObserver(obs);
    }
}
