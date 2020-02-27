public class Sorter {

	private MikeArray<Person> list;
	
	public Sorter(MikeArray<Person> arr) {
		list = arr;
	}
	
	//sorts by name
	public MikeArray<Person> nameSort(){
		MikeArray<Person> sorted = new MikeArray<Person>(list);
		MikeArray<String> names = new MikeArray<String>();
		
		for(int i = 0; i < list.size(); i++) {
			names.add(list.get(i).getName());
		}
		
		for(int i = 0; i < sorted.size()-1; i++) {
			int min_index = i;
			for(int j = i+1; j < sorted.size(); j++) {
				if(names.get(j).toLowerCase().compareTo(names.get(min_index).toLowerCase()) < 0) {
					min_index = j;
				}
			}
			
			String temp = names.get(min_index);
			names.set(min_index, names.get(i));
			names.set(i, temp);
			
			Person tempS = sorted.get(min_index);
			sorted.set(min_index, sorted.get(i));
			sorted.set(i, tempS);
			
		}
		
		return sorted;
	}
}
