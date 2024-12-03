package use_case.add_to_fav;

class AddToFavPresenterTest implements AddToFavOutputBoundary {
    private boolean successCalled = false;
    private boolean failureCalled = false;
    private String successMessage;
    private String failureMessage;

    @Override
    public void prepareSuccessView(String message) {
        this.successCalled = true;
        this.successMessage = message;
    }

    @Override
    public void prepareFailView(String errorMessage) {
        this.failureCalled = true;
        this.failureMessage = errorMessage;
    }

    public boolean isSuccessCalled() {
        return successCalled;
    }

    public boolean isFailureCalled() {
        return failureCalled;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public String getFailureMessage() {
        return failureMessage;
    }
}
