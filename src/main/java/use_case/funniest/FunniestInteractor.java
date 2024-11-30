package use_case.funniest;

import entity.Joke;

public class FunniestInteractor implements FunniestInputBoundary {

    private final FunniestDataAccessInterface funniestDataAccessInterface;
    private final FunniestOutputBoundary funniestOutputBoundary;

    public FunniestInteractor(FunniestDataAccessInterface funniestDataAccessInterface, FunniestOutputBoundary funniestoutputBoundary) {
        this.funniestDataAccessInterface = funniestDataAccessInterface;
        this.funniestOutputBoundary = funniestoutputBoundary;
    }

    @Override
    public void executeFunniest() {
        try {
            final String content = funniestDataAccessInterface.getFunniestJoke();
            final FunniestOutputData funniestOutputData = new FunniestOutputData(content);

            funniestOutputBoundary.prepareSuccessView(funniestOutputData);
        }
        catch (RuntimeException ex) {
            funniestOutputBoundary.prepareFailView(ex.getMessage());
        }
    }
}
