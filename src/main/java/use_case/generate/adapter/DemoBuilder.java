package use_case.generate.adapter;

import data_access.JokeDataAccessObject;
import use_case.generate.GenerateInteractor;

public class DemoBuilder {
    public static void build() {
        new GenerateController(new GenerateInteractor(new JokeDataAccessObject(), new DemoGeneratePresenter())).execute();
    }
}
