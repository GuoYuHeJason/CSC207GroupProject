package use_case.search;

import data_access.JokeDataAccessObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SearchInteractorTest {
    private TestSearchPresenter searchPresenter;
    private SearchInteractor searchInteractor;

    @BeforeEach
    void setUp() {
        JokeDataAccessObject jokeDataAccessObject = new JokeDataAccessObject();
        searchPresenter = new TestSearchPresenter();
        searchInteractor = new SearchInteractor(jokeDataAccessObject, searchPresenter);
    }

    @Test
    void testExecuteSearch_success() {
        // Arrange
        String keyword = "cat"; // Use a common keyword likely to produce results.

        // Act
        searchInteractor.executeSearch(keyword);

        // Assert
        assertTrue(searchPresenter.isSuccessCalled(), "Success view should be called");
        assertNotNull(searchPresenter.getSuccessData(), "Success data should not be null");
        assertFalse(searchPresenter.getSuccessData().getJokeContent().isEmpty(),
                "Joke content should not be empty");
        System.out.println("Retrieved joke: " + searchPresenter.getSuccessData().getJokeContent());
    }

    @Test
    void testExecuteSearch_failure() {
        // Arrange
        String keyword = "xyz123"; // Use a keyword unlikely to produce results.

        // Act
        searchInteractor.executeSearch(keyword);

        // Assert
        assertTrue(searchPresenter.isFailureCalled(), "Failure view should be called");
        assertEquals("failed to find a joke", searchPresenter.getFailureMessage(),
                "Failure message should match expected");
        System.out.println("Failure message: " + searchPresenter.getFailureMessage());
    }
}
