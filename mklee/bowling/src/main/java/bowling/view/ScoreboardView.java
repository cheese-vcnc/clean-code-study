package bowling.view;

import bowling.model.User;

import java.util.List;

public interface ScoreboardView {
    void showUserScoreboard(List<User> users);
}
