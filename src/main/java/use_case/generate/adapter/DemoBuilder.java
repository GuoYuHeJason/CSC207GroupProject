package use_case.generate.adapter;

import data_access.JokeDataAccessObject;
import use_case.generate.GenerateInteractor;

import javax.swing.*;

public class DemoBuilder {
    public static final int HEIGHT = 300;
    public static final int WIDTH = 400;

    public static JFrame build() {


        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Joke Machine");
        frame.setSize(WIDTH, HEIGHT);

        frame.add(new DemoAppView());

        return frame;

    }
}
