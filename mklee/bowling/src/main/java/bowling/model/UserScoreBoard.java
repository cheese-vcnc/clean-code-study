package bowling.model;

import bowling.BowlingConstants;

import java.util.ArrayList;
import java.util.List;

public class UserScoreBoard {
    List<UserFrameScore> frameScores;

    public UserScoreBoard() {
        frameScores = new ArrayList<>(BowlingConstants.FRAME_COUNT);
        for(int frame = 0; frame< BowlingConstants.FRAME_COUNT; ++frame){
            UserFrameScore frameScore = new UserFrameScore();
            frameScore.frame = frame;
            frameScores.add(frameScore);
        }
    }

    public static class UserFrameScore {
        int frame;
        int throwCount = 0;
        int score = 0;
    }
}
