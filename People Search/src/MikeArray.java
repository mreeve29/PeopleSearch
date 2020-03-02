import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MikeArray<E> implements List<E>{

	private static final byte INITIAL_CAPACITY = 10;
	private int size = 0;
	private Object[] elementData;
	
	public MikeArray(){
		elementData = new Object[INITIAL_CAPACITY];
	}

	public MikeArray(Object[] arr) {
		elementData = arr;
		size = arr.length;
	}
	
	public MikeArray(List<E> list) {
		elementData = list.toArray();
		size = list.size();
	}
	
	@Override
	public int size() {
		return size;
	}
	
	public int realSize() {
		return elementData.length;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return this.iterator();
	}

	@Override
	public Object[] toArray() {
		return Arrays.copyOf(elementData,size);
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		if(size == elementData.length) {
			expandArray();
		}
		elementData[size++] = e;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		c.forEach(this::add);
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		elementData = new Object[] {};
	}

	@Override
	public E get(int index) {
		return (E) elementData[index];
	}

	@Override
	public E set(int index, E element) {
		elementData[index] = element;
		return null;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E remove(int index) {
		Object removed = elementData[index];
		if(size - 1 - index >= 0) {
			System.arraycopy(elementData, index + 1, elementData, index, size - 1 - index);
		}
		size--;
		return (E) removed;
	}

	@Override
	public int indexOf(Object o) {
		if(o == null) {
            for(int i = 0; i < size; i++) {
            	if(elementData[i]==null) return i;
            }
        }else {
            for(int i = 0; i < size; i++) {
            	if(o.equals(elementData[i])) return i;
            }
        }
        return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void expandArray() {
		int newSize = elementData.length * 2;
		elementData = Arrays.copyOf(elementData, newSize);
	}

}
