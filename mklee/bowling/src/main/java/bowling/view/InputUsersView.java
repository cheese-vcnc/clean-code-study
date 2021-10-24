package bowling.view;

import bowling.model.User;

import java.util.List;

public interface InputUsersView {
    int getUserCount();
    List<User> getUsers(int userCount);
}
