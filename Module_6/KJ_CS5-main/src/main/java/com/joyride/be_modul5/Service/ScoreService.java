package com.joyride.be_modul5.Service;

import com.joyride.be_modul5.Model.Score;
import com.joyride.be_modul5.Repository.ScoreRepository;
import com.joyride.be_modul5.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerService playerService;

    @Transactional
    public Score createScore(Score score) {
        if (!playerRepository.existsById(score.getPlayerId())) {
            throw new RuntimeException("Player not found with ID: " + score.getPlayerId());
        }

        Score savedScore = scoreRepository.save(score);
        playerService.updatePlayerStats(score); //IDK what is wrong with this one
        return savedScore;
    }

    public Optional<Score> getScoreById(UUID scoreId) {
        return scoreRepository.findById(scoreId);
    }


    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }


    public List<Score> getScoresByPlayerId(UUID playerId) {
        return scoreRepository.findByPlayerId(playerId);
    }


    public List<Score> getScoresByPlayerIdOrderByValue(UUID playerId) {
        return scoreRepository.findByPlayerIdOrderByValueDesc(playerId);
    }

    public List<Score> findHighestScoreByPlayerId(UUID playerId) {
        return  scoreRepository.findHighestScoreByPlayerId(playerId);
        //if ( != 0) {return Optional.of(getAllScores());} else {return Optional.empty();}
    } //Still need to make the if l8r

    public List<Score> getScoresAboveValue(Integer minValue) {
        return scoreRepository.findByValueGreaterThan(minValue);
    }

    public List<Score> getRecentScores() {
        return scoreRepository.findAllByOrderByCreatedAtDesc();
    }

    public Integer getTotalCoinsByPlayerId(UUID playerId) {
        return scoreRepository.getTotalCoinsByPlayerId(playerId);
    }

    public Integer getTotalDistanceByPlayerId(UUID playerId) {
        return scoreRepository.getTotalDistanceByPlayerId(playerId);
    }

    public Score updateScore(UUID scoreId) {
        Optional<Score> existingScore = scoreRepository.findById(scoreId);
        playerService.updatePlayerStats(scoreId);
        return scoreRepository.save(existingScore);
    }
}