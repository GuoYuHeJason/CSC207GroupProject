package use_case.search.adapter;

import use_case.search.SearchOutputBoundary;
import use_case.search.SearchOutputData;
import view.joke_view.JokeFrameBuilder;

import javax.swing.*;

public class SearchPresenter implements SearchOutputBoundary {

    private final JokeFrameBuilder jokeFrameBuilder;

    public SearchPresenter(JokeFrameBuilder jokeFrameBuilder) {
        this.jokeFrameBuilder = jokeFrameBuilder;
    }

    @Override
    public void prepareSuccessView(SearchOutputData searchOutputData) {
        final JFrame frame = jokeFrameBuilder
                .addJokeView()
                .setJokeContent(searchOutputData.getJokeContent())
                .addExplanationUseCase()
                .addAddToFavUseCase()
                .build();

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void prepareFailureView(String errormessage) {
        final JFrame frame = jokeFrameBuilder
                .addJokeView()
                .setJokeContent(errormessage)
                .addExplanationUseCase()
                .addAddToFavUseCase()
                .build();

        frame.pack();
        frame.setVisible(true);
    }
}