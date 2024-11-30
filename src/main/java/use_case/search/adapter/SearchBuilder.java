package use_case.search.adapter;

import data_access.JokeDataAccessObject;
import use_case.search.SearchInteractor;
import view.joke_view.JokeFrameBuilder;
import view.SearchView;

import javax.swing.*;

public class SearchBuilder {
    public static final int HEIGHT = 300;
    public static final int WIDTH = 400;

    public static JFrame build() {

        final JFrame frame = new JFrame();
        final SearchViewModel viewModel = new SearchViewModel();
        final SearchView searchView = new SearchView(viewModel);
        final JokeFrameBuilder frameBuilder = new JokeFrameBuilder();
        final JokeDataAccessObject jokeDataAccessObject = new JokeDataAccessObject();
        final SearchPresenter searchPresenter = new SearchPresenter(frameBuilder);
        final SearchInteractor searchInteractor = new SearchInteractor(jokeDataAccessObject, searchPresenter);
        final SearchController searchController = new SearchController(searchInteractor);
        searchView.setSearchController(searchController);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Search");
        frame.setSize(WIDTH, HEIGHT);

        frame.add(searchView);

        return frame;

    }
}
