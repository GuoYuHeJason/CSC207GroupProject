package view;

import interface_adapter.favourite.FavouriteViewModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

import interface_adapter.favourite.FavouriteController;
import interface_adapter.favourite.FavouriteState;
import interface_adapter.favourite.FavouriteViewModel;

public class FavouriteView extends JPanel implements ActionListener, PropertyChangeListener {

    private final FavouriteController favouriteController;
    private final FavouriteViewModel favouriteviewmodel;

    private final String viewName = "Favourite";
    private FavouriteView favouriteView;

    private final JLabel search = new JLabel("Enter keyword to find a joke:");
    private final JTextArea keywordInputField = new JTextArea();

    private final JTextField searchBox = new JTextField(15);
    private final JButton searchButton;
    private final JButton funniestButton;

    public FavouriteView(FavouriteViewModel favouriteviewmodel, FavouriteController favouritecontroller, FavouriteViewModel favouriteviewmodel1) {
        this.favouriteController = favouritecontroller;
        this.favouriteviewmodel = favouriteviewmodel1;
        this.favouriteviewmodel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Favourite");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel buttons = new JPanel();
        funniestButton = new JButton("Funniest");
        buttons.add(funniestButton);
        searchButton = new JButton("search");
        buttons.add(searchButton);

        funniestButton.addActionListener(
                evt -> {
                    if (evt.getSource().equals(funniestButton)) {
                        favouriteController.execute(favouriteInputField.getText());

                    }
                }
        );

        refreshButton.addActionListener(
                evt -> {
                    if (evt.getSource().equals(refreshButton)) {
                        favouriteController.execute(null);

                    }
                }
        );
    }

    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    public void propertyChange(PropertyChangeEvent evt) {
        final FavouriteState state = (FavouriteState) evt.getNewValue();
        setFields(state);
        usernameErrorField.setText(state.getFavouriteError());
    }

    private void setFields(FavouriteState state) {
        usernameInputField.setText(state.getUsername());
    }

    public String getViewName() {
        return viewName;
    }
}
