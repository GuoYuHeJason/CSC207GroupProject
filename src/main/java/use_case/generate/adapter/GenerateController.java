package use_case.generate.adapter;

import use_case.generate.GenerateInputBoundary;

/**
 * Controller for our generate Use Cases.
 */
public class GenerateController {

    private final GenerateInputBoundary generateInputBoundary;

    public GenerateController(GenerateInputBoundary generateInputBoundary) {
        this.generateInputBoundary = generateInputBoundary;
    }

    /**
     * Executes the generate related Use Cases.
     */
    public void execute() {
        generateInputBoundary.executeGenerate();
    }
}
