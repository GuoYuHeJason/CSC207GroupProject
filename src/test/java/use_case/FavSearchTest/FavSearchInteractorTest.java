package use_case.fav_search;

import entity.Joke;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.FavSearchTest.TestFavSearchPresenter;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FavSearchInteractorTest {
    private TestFavSearchPresenter favSearchPresenter;
    private FavSearchInteractor favSearchInteractor;

    @BeforeEach
    void setUp() {
        FavSearchDataAccessInterface mockDataAccess = new FavSearchDataAccessInterface() {
            @Override
            public List<Joke> getFavourites() {
                List<Joke> favourites = new ArrayList<>();
                favourites.add(new Joke("Why did the chicken cross the road?", 5));
                favourites.add(new Joke("Why was the math book sad?", 7));
                return favourites;
            }
        };

        favSearchPresenter = new TestFavSearchPresenter();
        favSearchInteractor = new FavSearchInteractor(favSearchPresenter, mockDataAccess);
    }

    @Test
    void testExecuteSearch_success() {
        // Arrange
        String keyword = "chicken"; // Use a keyword that matches a joke

        // Act
        favSearchInteractor.executeSearch(keyword);

        // Assert
        assertTrue(favSearchPresenter.isSuccessCalled(), "Success view should be called");
        assertNotNull(favSearchPresenter.getSuccessData(), "Success data should not be null");
        assertEquals("Why did the chicken cross the road?",
                favSearchPresenter.getSuccessData().getJokeContent(),
                "Joke content should match expected");
    }

    @Test
    void testExecuteSearch_failure() {
        // Arrange
        String keyword = "unicorn"; // Use a keyword that does not match any joke

        // Act
        favSearchInteractor.executeSearch(keyword);

        // Assert
        assertTrue(favSearchPresenter.isFailureCalled(), "Failure view should be called");
        assertEquals("No matching jokes found in favourites.",
                favSearchPresenter.getFailureMessage(),
                "Failure message should match expected");
    }

    @Test
    void testExecuteSearch_errorHandling() {
        // Arrange
        FavSearchDataAccessInterface errorDataAccess = new FavSearchDataAccessInterface() {
            @Override
            public List<Joke> getFavourites() {
                throw new RuntimeException("Mock data access error");
            }
        };

        favSearchInteractor = new FavSearchInteractor(favSearchPresenter, errorDataAccess);

        // Act
        favSearchInteractor.executeSearch("any keyword");

        // Assert
        assertTrue(favSearchPresenter.isFailureCalled(), "Failure view should be called on error");
        assertEquals("Error searching favourites: Mock data access error",
                favSearchPresenter.getFailureMessage(),
                "Failure message should match expected error handling");
    }
}
