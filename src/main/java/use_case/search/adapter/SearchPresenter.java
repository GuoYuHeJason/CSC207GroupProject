package use_case.search.adapter;

import data_access.FileDataAccessObject;
import use_case.search.SearchOutputBoundary;
import use_case.search.SearchOutputData;
import view.joke_view.JokeFrameBuilder;
import visitor.Visitor;

import javax.swing.*;

public class SearchPresenter implements SearchOutputBoundary {

    private final Visitor searchVisitor;
    private final JokeFrameBuilder jokeFrameBuilder;

    public SearchPresenter(FileDataAccessObject fileDataAccessObject, JokeFrameBuilder jokeFrameBuilder) {
        this.searchVisitor = new Visitor(fileDataAccessObject);
        this.jokeFrameBuilder = jokeFrameBuilder;
    }

    @Override
    public void prepareSuccessView(SearchOutputData searchOutputData) {
        searchVisitor.visit(searchOutputData);
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