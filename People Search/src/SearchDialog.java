import BreezySwing.*;
import javax.swing.*;

public class SearchDialog extends GBDialog{

	private JLabel searchLabel = addLabel("Enter the name to be searched and select the desired method",1,1,2,1);
	
	private JTextField searchField = addTextField("",2,1,2,1);
	
	private JButton sequentialButton = addButton("Sequential Search",3,1,1,1);
	
	private JButton binaryButton = addButton("Binary Search",3,2,1,1);
	
	private MikeArray<Person> list;
	
	public void buttonClicked(JButton button) {
		String name = searchField.getText();
		if(button == sequentialButton) {
			Search<Person> s = new Search<Person>(list);
			try {
				Person found = s.sequentialSearch(new Person(0,name));
				new EditPersonDialog(null, list, found,s.getComparisons());
			}catch (NullPointerException e) {
				messageBox("\"" + name + "\" " + e.getMessage());
			}
			
		}else if (button == binaryButton) {
			Sorter sort = new Sorter(list);
			Search<Person> s = new Search<Person>(sort.nameSort());
			try {
				Person found = s.binarySearch(new Person(0,name));
				new EditPersonDialog(null, list, found,s.getComparisons());
			}catch (NullPointerException e) {
				messageBox("\"" + name + "\" " + e.getMessage());
			}
		}
	}
	
	
	public SearchDialog(JFrame parent, MikeArray<Person> arr) {
		super(parent);
		list = arr;
		setSize(400,400);
		setVisible(true);
		setTitle("Search");
	}

}
