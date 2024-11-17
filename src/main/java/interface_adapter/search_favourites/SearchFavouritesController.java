package interface_adapter.search_favourites;

import use_case.search_favourites.SearchFavouritesInputBoundary;

public class SearchFavouritesController {

    private final SearchFavouritesInputBoundary interactor;

    public SearchFavouritesController(SearchFavouritesInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void executeSearch(String keyword) {
        interactor.searchFavourites(keyword);
    }
}
