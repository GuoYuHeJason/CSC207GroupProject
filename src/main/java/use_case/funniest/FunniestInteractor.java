package use_case.funniest;

import use_case.explanation.ExplanationInputData;
import use_case.explanation.ExplanationOutputData;
import use_case.favourite.FavouriteOutputBoundary;

public class FunniestInteractor {
    private final FavouriteOutputBoundary favouriteOutputBoundary;

    public FunniestInteractor(FavouriteOutputBoundary outputBoundary) {
        this.favouriteOutputBoundary = outputBoundary;
    }

    public void executeFunniest(FavouriteOutputBoundary explanationInputData) {
        try {
            final String explanation = explanationDataAccessObject.getExplanation(explanationInputData.getJokeContent());
            explanationOutputBoundary.prepareSuccessView(new ExplanationOutputData(explanation));
        }
        catch (RuntimeException ex) {
            explanationOutputBoundary.prepareFailView(ex.getMessage());
        }
    }
}
