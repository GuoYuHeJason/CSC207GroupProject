package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import interface_adapter.joke.JokeController;
import interface_adapter.joke.JokeViewModel;
import use_case.favourite.adapter.FavouriteController;
import use_case.generate.adapter.GenerateController;
import use_case.search.adapter.SearchController;

/**
 * The Main View for interacting with the Joke Application.
 */
public class MainView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "joke view";
    private final JokeViewModel jokeViewModel;

    private final JLabel userIdLabel = new JLabel("User ID: ");
    private final JButton generateJokeButton = new JButton("Generate Joke");
    private final JButton searchJokeButton = new JButton("Search Joke");
    private final JButton favouritePageButton = new JButton("Go to Favourites");
    private final JButton logoutButton = new JButton("Log out");
    private JokeController jokeController;
    private GenerateController generateController;
    private FavouriteController favouriteController;
    private SearchController searchController;

    public MainView(JokeViewModel jokeViewModel) {
        this.jokeViewModel = jokeViewModel;

        this.jokeViewModel.addPropertyChangeListener(this);

        setupButtons();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(userIdLabel);
        this.add(generateJokeButton);
        this.add(searchJokeButton);
        this.add(favouritePageButton);
        this.add(logoutButton);
    }

    /**
     * Configures the actions for each button.
     */
    private void setupButtons() {
        generateJokeButton.addActionListener(event -> jokeController.execute("Generate", ""));

        searchJokeButton.addActionListener(event -> {
            final String query = JOptionPane.showInputDialog(this, "Search Joke:");
            if (query != null && !query.trim().isEmpty()) {
                jokeController.execute("search", query);
            }
        });
        favouritePageButton.addActionListener(event -> {
        });
        logoutButton.addActionListener(event -> {
        });
    }

    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    /**
     * Handles updates from the JokeViewModel.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("error".equals(evt.getPropertyName())) {
            JOptionPane.showMessageDialog(this, evt.getNewValue().toString(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getViewName() {
        return viewName;
    }

    public void setGenerateController(GenerateController generateController) {
        this.generateController = generateController;
    }

    public void setSearchController(SearchController searchController) {
        this.searchController = searchController;
    }

    public void setFavouriteController(FavouriteController favouriteController) {
        this.favouriteController = favouriteController;
    }
}
