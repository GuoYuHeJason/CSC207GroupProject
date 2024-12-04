package use_case.FavSearchTest;

import use_case.fav_search.FavSearchOutputBoundary;
import use_case.fav_search.FavSearchOutputData;

public class TestFavSearchPresenter implements FavSearchOutputBoundary {
    private boolean successCalled = false;
    private boolean failureCalled = false;
    private FavSearchOutputData successData;
    private String failureMessage;

    @Override
    public void prepareSuccessView(FavSearchOutputData searchFavouritesOutputData) {
        successCalled = true;
        successData = searchFavouritesOutputData;
    }

    @Override
    public void presentFailure(String message) {
        failureCalled = true;
        failureMessage = message;
    }

    public boolean isSuccessCalled() {
        return successCalled;
    }

    public boolean isFailureCalled() {
        return failureCalled;
    }

    public FavSearchOutputData getSuccessData() {
        return successData;
    }

    public String getFailureMessage() {
        return failureMessage;
    }
}
