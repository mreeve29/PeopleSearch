import javax.swing.*;
import BreezySwing.*;

public class EditPersonDialog extends GBDialog {

	private JLabel comparisonsLabel = addLabel("",1,1,1,1);
	
	private JLabel nameLabel = addLabel("Name:",2,1,1,1);
	private JTextField nameField = addTextField("",2,2,1,1);
	
	private JLabel ageLabel = addLabel("Age:",3,1,1,1);
	private IntegerField ageField = addIntegerField(0,3,2,1,1);
	
	private JButton deleteButton = addButton("Delete Person",4,1,1,1);
	private JButton updateButton = addButton("Update Person",4,2,1,1);
	
	private MikeArray<Person> list;
	private Person current;
	
	public void buttonClicked(JButton button) {
		if(button == deleteButton) {
			int response = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this person?","Confirm Deletion", JOptionPane.YES_NO_OPTION);
			if(response == JOptionPane.YES_OPTION) {
				//delete
				list.remove(list.indexOf(current));
				System.out.println(list.size() + " " + list.realSize());
				dispose();
			}
		}else if(button == updateButton) {
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
			
			current.setName(name);
			current.setAge(age);
			dispose();
		}
	}
	
	//error checking helper method
	private boolean isBlank(String s) {
		for(int i = 0; i < s.length(); i++) {
			if(!Character.isWhitespace(s.charAt(i))) return false;
		}
		return true;
	}
	
	
	public EditPersonDialog(JFrame parent, MikeArray<Person> arr, Person p, int count) {
		super(parent);
		
		nameField.setText(p.getName());
		ageField.setNumber(p.getAge());
		list = arr;
		current = p;
		comparisonsLabel.setText("Took " + count + " comparisons");
		
		setSize(400,400);
		setTitle("Edit " + p.getName());
		setVisible(true);
	}

}
