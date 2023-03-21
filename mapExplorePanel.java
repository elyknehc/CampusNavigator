import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class mapExplorePanel extends JPanel {
   JTextField searchBar;
   JCheckBox washrooms, classrooms, genLabs, stairwells, entryExits, elevators, userCreatedPOIs, favourites;
   
   public mapExplorePanel() {
      // create JPanel for left panel and set properties
      setBounds(0, 0, 333, 600);
      setLayout(null);

      // create JTextField for search bar and set properties
      searchBar = new JTextField("Search");
      searchBar.setBounds(50, 50, 200, 25);
      // Function to setup default text to dissappear or reappear
      searchBar.addFocusListener(new FocusListener() {
         public void focusGained(FocusEvent e) {
             searchBar.setText("");
         }
         public void focusLost(FocusEvent e) {
             if (searchBar.getText().isEmpty()) {
                 searchBar.setText("Search");
             }
         }
     });
      
      // create search button and set properties
      JButton searchButton = new JButton();
      searchButton.setBounds(253, 51, 22, 22);
      ImageIcon search = new ImageIcon("./images/searchButton.jpg");
      Image searchImage = search.getImage().getScaledInstance(searchButton.getWidth(), searchButton.getHeight(), Image.SCALE_SMOOTH);
        search = new ImageIcon(searchImage);
      searchButton.setIcon(search);
      // Function to return text from the searchbar
      searchButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String searchText = searchBar.getText();
            System.out.println("Search text: " + searchText);
        }
    });
      
      // create JLabel for POI Layers subheading and set properties
      JLabel poiLabel = new JLabel("POI Layers");
      poiLabel.setFont(new Font("Arial", Font.BOLD, 16));
      poiLabel.setBounds(50, 100, 200, 25);

      // create checkboxes for POI Layers and set properties
      washrooms = new JCheckBox("Washrooms");
      washrooms.setBounds(50, 150, 200, 25);
      classrooms = new JCheckBox("Classrooms");
      classrooms.setBounds(50, 175, 200, 25);
      genLabs = new JCheckBox("GenLabs");
      genLabs.setBounds(50, 200, 200, 25);
      stairwells = new JCheckBox("Stairwells");
      stairwells.setBounds(50, 225, 200, 25);
      entryExits = new JCheckBox("Entry/Exits");
      entryExits.setBounds(50, 250, 200, 25);
      elevators = new JCheckBox("Elevators");
      elevators.setBounds(50, 275, 200, 25);
      userCreatedPOIs = new JCheckBox("User-created POIs");
      userCreatedPOIs.setBounds(50, 300, 200, 25);
      favourites = new JCheckBox("Favourites");
      favourites.setBounds(50, 325, 200, 25);

      // create dropdown menu for floors and set properties
      String[] floors = {"Floor 1", "Floor 2", "Floor 3"};
      JComboBox<String> floorDropdown = new JComboBox<>(floors);
      floorDropdown.setBounds(50, 375, 200, 25);

      // create JButton for adding POIs and set properties
      JButton addPOIButton = new JButton("Add POI");
      addPOIButton.setBounds(50, 425, 200, 25);

      // add components to left panel
      add(searchBar);
      add(searchButton);
      add(poiLabel);
      add(washrooms);
      add(classrooms);
      add(genLabs);
      add(stairwells);
      add(entryExits);
      add(elevators);
      add(userCreatedPOIs);
      add(favourites);
      add(floorDropdown);
      add(addPOIButton);
   }

    private boolean[] getFilterValeus() {
        boolean[] filterValues = {washrooms.isSelected(), classrooms.isSelected(), genLabs.isSelected(), stairwells.isSelected(), entryExits.isSelected(), elevators.isSelected(), userCreatedPOIs.isSelected(), favourites.isSelected()};
        return filterValues;
    }
}
