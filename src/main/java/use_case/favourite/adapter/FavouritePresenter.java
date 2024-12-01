package use_case.favourite.adapter;

import use_case.favourite.FavouriteOutputBoundary;
import use_case.favourite.FavouriteOutputData;
import view.ViewManagerModel;
import view.favourite_view.FavouriteState;
import view.favourite_view.FavouriteViewModel;

public class FavouritePresenter implements FavouriteOutputBoundary {

    private final FavouriteViewModel favouriteViewModel;
    private final ViewManagerModel viewManagerModel;

    public FavouritePresenter(FavouriteViewModel favouriteViewModel, ViewManagerModel viewManagerModel) {
        this.favouriteViewModel = favouriteViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(FavouriteOutputData favouriteOutputData) {
        final FavouriteState favouriteState = favouriteViewModel.getState();
        favouriteState.setFavourites(favouriteOutputData.getFavouriteJokeList());
        favouriteViewModel.setState(favouriteState);
        favouriteViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {

    }

    @Override
    public void switchToFavouriteView() {
        viewManagerModel.setState(favouriteViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}