import BreezySwing.*;
import javax.swing.*;

public class AddPersonDialog extends GBDialog{

	private JLabel nameLabel = addLabel("Name: ",1,1,1,1);
	private JTextField nameField = addTextField("",1,2,1,1);
	
	private JLabel ageLabel = addLabel("Age:",2,1,1,1);
	private IntegerField ageField = addIntegerField(0,2,2,1,1);
	
	private JButton addButton = addButton("Add Person",3,2,1,1);
	
	private MikeArray<Person> list;
	
	public void buttonClicked(JButton button) {
		if(button == addButton) {
			String name = nameField.getText();
			if(isBlank(name)) {
				messageBox("Empty name");
				return;
			}
			
			if(!ageField.isValidNumber()) {
				messageBox("Invalid integer");
				return;
			}
			
			int age = ageField.getNumber();
			
			if(age < 0) {
				messageBox("Age cannot be negative");
				return;
			}
			
			list.add(new Person(age,name));
			
		}
	}
	
	
	//error checking helper method
	private boolean isBlank(String s) {
		for(int i = 0; i < s.length(); i++) {
			if(!Character.isWhitespace(s.charAt(i))) return false;
		}
		return true;
	}
	
	
	public AddPersonDialog(JFrame parent, MikeArray<Person> arr) {
		super(parent);
		
		list = arr;
		
		setSize(400,400);
		setTitle("Add Person");
		setVisible(true);
	}

}
