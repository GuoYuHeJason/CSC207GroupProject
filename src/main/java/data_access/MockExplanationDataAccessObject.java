package data_access;

import use_case.explain.ExplanationDataAccessInterface;

public class MockExplanationDataAccessObject implements ExplanationDataAccessInterface {

    @Override
    public String getExplanation(String joke) {
        return "haha, that's funny";
    }
}
