import BreezySwing.*;
import javax.swing.*;

public class PeopleSearchGUI extends GBFrame{

	private JButton addButton = addButton("Add Person",1,1,1,1);
	
	private JButton searchButton = addButton("Search",2,1,1,1);
	
	private JButton nameSortButton = addButton("Sort by name",3,1,1,1);
	
	private MikeArray<Person> peopleList;
	
	public void buttonClicked(JButton button) {
		if(button == addButton) {
			new AddPersonDialog(this, peopleList);
		}else if(button == searchButton) {
			new SearchDialog(this, peopleList);
		}else if(button == nameSortButton) {
			Sorter s = new Sorter(peopleList);
			String output = "";
			for(Object p : s.nameSort().toArray()) {
				p = (Person)p;
				output += p.toString() + '\n';
			}
			messageBox(output);
		}
	}
	
	
	
	public PeopleSearchGUI() {
		peopleList = new MikeArray<Person>();
		
		setSize(400,400);
		setTitle("People Search");
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new PeopleSearchGUI();
	}
	
}
