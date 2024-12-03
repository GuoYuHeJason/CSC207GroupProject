package use_case.search;

class TestSearchPresenter implements SearchOutputBoundary {
    private boolean successCalled = false;
    private boolean failureCalled = false;
    private SearchOutputData successData = null;
    private String failureMessage = null;

    @Override
    public void prepareSuccessView(SearchOutputData data) {
        successCalled = true;
        successData = data;
    }

    @Override
    public void prepareFailureView(String message) {
        failureCalled = true;
        failureMessage = message;
    }

    @Override
    public void switchToSearchView() {
        // Not used in this test
    }

    @Override
    public void switchToMainView() {
        // Not used in this test
    }

    // Getters for assertions
    public boolean isSuccessCalled() { return successCalled; }
    public boolean isFailureCalled() { return failureCalled; }
    public SearchOutputData getSuccessData() { return successData; }
    public String getFailureMessage() { return failureMessage; }
}
