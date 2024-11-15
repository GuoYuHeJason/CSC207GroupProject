package use_case.explanation.adapter;

import use_case.explanation.ExplanationOutputBoundary;
import view.joke_view.JokeViewModel;

public class ExplanationPresenter implements ExplanationOutputBoundary {
    //TODO implement

    public ExplanationPresenter(JokeViewModel jokeViewModel) {
    }

    @Override
    public void prepareSuccessView(String explanation) {

    }

    @Override
    public void prepareFailView(String errorMessage) {

    }
}
