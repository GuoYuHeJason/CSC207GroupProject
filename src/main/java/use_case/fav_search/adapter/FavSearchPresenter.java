package use_case.fav_search.adapter;

import use_case.fav_search.FavSearchOutputBoundary;
import use_case.fav_search.FavSearchOutputData;
import view.favourite_view.FavouriteView;
import view.favourite_view.FavouriteViewModel;
import view.joke_view.JokeFrameBuilder;

import javax.swing.*;

/**
 Search favourites presenter.
 */

public class FavSearchPresenter implements FavSearchOutputBoundary {

    private final FavouriteView favouriteView;
    private final JokeFrameBuilder jokeFrameBuilder;

    public FavSearchPresenter(FavouriteViewModel favouriteView, JokeFrameBuilder jokeFrameBuilder) {
        this.favouriteView = favouriteView;
        this.jokeFrameBuilder = jokeFrameBuilder;
    }

    @Override
    public void prepareSuccessView(FavSearchOutputData searchFavouritesOutputData) {
        final JFrame frame = jokeFrameBuilder
                .addJokeView()
                .setJokeContent(searchFavouritesOutputData.getJokeContent())
                .addExplanationUseCase()
                .addAddToFavUseCase()
                .build();

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void presentFailure(String message) {

    }
}
