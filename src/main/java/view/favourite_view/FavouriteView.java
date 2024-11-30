package view.favourite_view;

import entity.Joke;
import use_case.favourite.FavouriteInteractor;
import view.helper_functions.LabelTextPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.*;

import use_case.favourite.adapter.FavouriteController;
import visitor.Visitor;

public class FavouriteView extends JPanel implements ActionListener, PropertyChangeListener {

    private final FavouriteViewModel favouriteViewModel;

    private final String viewName;
    private FavouriteView favouriteView;

    private FavouriteController favouriteController;

    private final JTextField searchBox = new JTextField(15);
    private final JButton searchButton;
    private final JButton funniestButton;
    private final JButton cancelButton;

    public FavouriteView(FavouriteViewModel favouriteViewModel) {
        this.favouriteViewModel = favouriteViewModel;
        this.viewName = favouriteViewModel.getViewName();
        this.favouriteViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel(FavouriteViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final LabelTextPanel search = new LabelTextPanel(new JLabel(FavouriteViewModel.KEYWORD_LABEL), searchBox);

        final JPanel buttons = new JPanel();
        searchButton = new JButton(FavouriteViewModel.SEARCH_BUTTOM_LABEL);
        buttons.add(searchButton);
        funniestButton = new JButton(FavouriteViewModel.FUNNIEST_BUTTOM_LABEL);
        buttons.add(funniestButton);
        cancelButton = new JButton(FavouriteViewModel.CANCEL_BUTTOM_LABEL);
        buttons.add(cancelButton);
        buttons.add(search);

        final JPanel jokeListPanel = new JPanel();
        List<Joke> fav = favouriteViewModel.getState().getFavourites();
        for (int i = 0; i < fav.size(); i++) {
            String content = fav.get(i).getContent();
            jokeListPanel.add(new JLabel(content));
        }

        final JSplitPane mainPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

        mainPanel.setLeftComponent(buttons);
        mainPanel.setRightComponent(jokeListPanel);

        this.add(title);
        this.add(mainPanel);

        funniestButton.addActionListener(
                evt -> {
                    if (evt.getSource().equals(funniestButton)) {
                        funniestController.execute();
                    }
                }
        );

        cancelButton.addActionListener(this);

        searchButton.addActionListener(
                evt -> {
                    if (evt.getSource().equals(searchButton)) {

                    }
                }
//    /**
//     * React to a button click that results in evt.
//     * @param evt the ActionEvent to react to
//     */
//    public void actionPerformed(ActionEvent evt) {
//        System.out.println("Click " + evt.getActionCommand());
//    }
//
//    public void propertyChange(PropertyChangeEvent evt) {
//        final FavouriteState state = (FavouriteState) evt.getNewValue();
//        setFields(state);
//        usernameErrorField.setText(state.getFavouriteError());
//    }
//
//    private void setFields(FavouriteState state) {
//        usernameInputField.setText(state.getUsername());
//    }
//
//    public String getViewName() {
//        return viewName;
//    }
    }

    public void setFavouriteController(FavouriteController controller) {
        this.favouriteController = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}