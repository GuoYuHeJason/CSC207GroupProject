package use_case.generate;

import use_case.note.DataAccessException;
import use_case.note.NoteDataAccessInterface;
import use_case.note.NoteOutputBoundary;

/**
 * The "Use Case Interactor" for generating joke
 */
public class GenerateInteractor implements GenerateInputBoundary{

    private final GenerateDataAccessInterface generateDataAccessInterface;
    private final GenerateOuputBoundary generateOuputBoundary;

    public GenerateInteractor(GenerateDataAccessInterface generateDataAccessInterface,
                          GenerateOuputBoundary generateOuputBoundary) {
        this.generateDataAccessInterface = generateDataAccessInterface;
        this.generateOuputBoundary = generateOuputBoundary;
    }

    @Override
    public void executeGenerate() {
        try {
            final String jokeContent = generateDataAccessInterface.getJokeContent();
            generateOuputBoundary.prepareSuccessView(jokeContent);
        }
        catch (RuntimeException ex) {
            generateOuputBoundary.prepareFailView(ex.getMessage());
        }
    }
}