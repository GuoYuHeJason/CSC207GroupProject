package use_case.add_to_fav;

/**
 * The AddToFav Output Boundary interface defines the output boundary
 * for the Add to Favorites use case.
 */
public interface AddToFavOutputBoundary {

    void prepareSuccessView(String added);

    void prepareFailView(String error);
}
