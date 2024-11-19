package use_case.favourite;

import java.util.List;

import entity.Joke;
import entity.User;

public interface FavouriteUserDataAccessInterface {
    List<Joke> getFavouriteUsers(User user);
}
