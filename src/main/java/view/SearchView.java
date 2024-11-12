package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import use_case.search.adapter.SearchController;
import use_case.search.adapter.SearchViewModel;
import view.helper_functions.LabelTextPanel;

public class SearchView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "Search";
    private final SearchViewModel searchViewModel;

    private final JLabel search = new JLabel("Enter keyword to find a joke:");
    private final JTextField keywordInputField = new JTextField(15);

    private final JButton searchButton = new JButton("Search");
    private final JButton cancelButton = new JButton("Cancel");
    private SearchController searchController;

    public SearchView(SearchViewModel searchViewModel) {
        this.searchViewModel = searchViewModel;
        this.searchViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel(SearchViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final LabelTextPanel searchBox = new LabelTextPanel(this.search, this.keywordInputField);

        final JPanel buttons = new JPanel();
        buttons.add(searchButton);
        buttons.add(cancelButton);

        searchButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(searchButton)) {
                            searchController.execute(keywordInputField.getText());
                        }
                    }
                }
        );

        cancelButton.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(searchBox);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}

