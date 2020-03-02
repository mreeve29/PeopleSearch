
public class Search<T extends Comparable<T>> {
	
	private MikeArray<T> list;
	private int comparisons;
	
	public Search(MikeArray<T> array){
		list = array;
		comparisons = 0;
	}
	
	public int getComparisons() {
		return comparisons;
	}
	
	public T binarySearch(T item) throws NullPointerException{
		comparisons = 0;
		int first = 0;
		int last = list.size()-1;
		int n = list.size()/2;
		
		while(first <= last) {
			comparisons++;
			if(list.get(n).compareTo(item) < 0) {
				//right half
				first = n + 1;
			}else if (list.get(n).compareTo(item) > 0) {
				//left half
				last = n - 1;
			}else {
				//equals
				return list.get(n);
			}
			n = (first + last)/2;
		}
		throw new NullPointerException("Not found");
	}
	
	public T sequentialSearch(T item) throws NullPointerException{
		for(int i = 0; i < list.size(); i++) {
			comparisons++;
			if(list.get(i).compareTo(item) == 0) {
				//found
				return list.get(i);
			}
		}
		throw new NullPointerException("Not found");
	}
	
	
}
