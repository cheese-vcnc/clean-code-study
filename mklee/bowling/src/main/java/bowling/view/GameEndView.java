package bowling.view;

import bowling.model.User;

import java.util.List;

public interface GameEndView {
    void showGameEndWithScoreboard(List<User> users);
}
