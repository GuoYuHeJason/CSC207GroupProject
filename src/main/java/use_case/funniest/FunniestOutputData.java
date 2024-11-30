package use_case.funniest;

public class FunniestOutputData {
    private final String jokeContent;

    public FunniestOutputData(String jokeContent) {
        this.jokeContent = jokeContent;
    }

    String getJokeContent() {
        return jokeContent;
    }
}
