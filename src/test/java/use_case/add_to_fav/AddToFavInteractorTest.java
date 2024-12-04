package use_case.add_to_fav;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddToFavInteractorTest {
    private AddToFavPresenterTest addToFavPresenter;
    private AddToFavInteractor addToFavInteractor;

    @BeforeEach
    void setUp() {
        MockAddToFavDataAccess mockDataAccess = new MockAddToFavDataAccess();
        addToFavPresenter = new AddToFavPresenterTest();
        addToFavInteractor = new AddToFavInteractor(mockDataAccess, addToFavPresenter);
    }

    @Test
    void testExecuteAddToFav_success() {
        // Arrange
        String jokeContent = "Why don't scientists trust atoms? They make up everything!";
        String explanation = "A pun on atoms and lies.";

        AddToFavInputData inputData = new AddToFavInputData(jokeContent, explanation);

        // Act
        addToFavInteractor.executeAddToFav(inputData);

        // Assert
        assertTrue(addToFavPresenter.isSuccessCalled(), "Success view should be called");
        assertEquals("Added", addToFavPresenter.getSuccessMessage(), "Success message should match expected");
        System.out.println("Success message: " + addToFavPresenter.getSuccessMessage());
    }

    @Test
    void testExecuteAddToFav_failure_userNotFound() {
        // Arrange
        String jokeContent = "Why don't scientists trust atoms? They make up everything!";
        String explanation = "A pun on atoms and lies.";

        // Simulate a non-existent user
        addToFavInteractor = new AddToFavInteractor(new MockAddToFavDataAccess(), addToFavPresenter);

        AddToFavInputData inputData = new AddToFavInputData(jokeContent, explanation);

        // Act
        addToFavInteractor.executeAddToFav(inputData);

        // Assert
        assertTrue(addToFavPresenter.isFailureCalled(), "Failure view should be called");
        assertEquals("User not found.", addToFavPresenter.getFailureMessage(), "Failure message should match expected");
        System.out.println("Failure message: " + addToFavPresenter.getFailureMessage());
    }

    @Test
    void testExecuteAddToFav_failure_invalidJokeContent() {
        // Arrange
        String jokeContent = "";
        String explanation = "Explanation for an invalid joke.";

        AddToFavInputData inputData = new AddToFavInputData(jokeContent, explanation);

        // Act
        addToFavInteractor.executeAddToFav(inputData);

        // Assert
        assertTrue(addToFavPresenter.isFailureCalled(), "Failure view should be called");
        assertEquals("Invalid joke content.", addToFavPresenter.getFailureMessage(), "Failure message should match expected");
        System.out.println("Failure message: " + addToFavPresenter.getFailureMessage());
    }
}
