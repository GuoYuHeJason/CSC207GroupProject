package app;

import javax.swing.*;

/**
 * The Main class of our application.
 */
public class Main {
    /**
     * Builds and runs the CA architecture of the application.
     * @param args unused arguments
     */
    public static void main(String[] args) {
        final AppBuilder appBuilder = new AppBuilder();
        final JFrame application = appBuilder
                                            .addLoginView()
                                            .addSignupView()
                                            .addMainView()
                                            .addFavouriteView()
                                            .addSearchView()
                                            .addSignupUseCase()
                                            .addLoginUseCase()
                                            .addSearchUseCase()
                                            .addFavouriteUseCase()
                                            .addGenerateUseCase()
                                            .addFunniestUseCase()
                                            .addFavSearchUseCase()
                                            .addLogoutUseCase()
                                            .build();

        application.pack();
        application.setVisible(true);
    }
}
