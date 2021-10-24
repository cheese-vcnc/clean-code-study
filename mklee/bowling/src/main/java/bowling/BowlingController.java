package bowling;

import bowling.model.User;
import bowling.model.UserScoreBoard;
import bowling.rule.BowlingActionRule;
import bowling.rule.BowlingScoreRule;
import bowling.view.*;

import java.util.List;

public class BowlingController {
    GameBeginView gameBeginView;
    GameEndView gameEndView;
    InputUsersView inputUsersView;
    InputThrowView inputThrowView;
    ScoreboardView scoreboardView;

    BowlingActionRule actionRule;
    BowlingScoreRule scoreRule;

    public void runGame() {
        gameBeginView.showGameBegin();

        int userCount = inputUsersView.getUserCount();
        List<User> users = inputUsersView.getUsers(userCount);
        for (int frame = 0; frame< BowlingConstants.FRAME_COUNT; ++frame) {
            runFrame(users);
        }

        gameEndView.showGameEndWithScoreboard(users);
    }

    private void runFrame(List<User> users) {
        for (User user : users) {
            runThrow(user);
            scoreboardView.showUserScoreboard(users);
        }
    }

    private void runThrow(User user) {
        UserScoreBoard prevScore = user.userScoreBoard;
        int throwPoint = inputThrowView.getThrowPoint();

        user.userScoreBoard = scoreRule.calcUserScore(throwPoint, prevScore);
        if(actionRule.throwAgain(throwPoint, prevScore)) {
            runThrow(user);
        }
    }
}
