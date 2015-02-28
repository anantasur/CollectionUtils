import java.util.*;

interface ListMapper<E,K> {
	public K map(E element);
}

interface ListFilter<E> {
	public boolean filter(E element);
}


interface ListReducer<E,K>{
	public K compare(K previousValue,E currentValue);
}

public class CollectionUtils {

	public static <E,K> List<K> map(List<E> list, ListMapper<E,K> mapper){
		List<K> newlist = new ArrayList<K>();
		for(E ele :list){
			newlist.add(mapper.map(ele));
		} 
		return newlist;
	}

	public static<E> List<E> filter(List<E> list, ListFilter listFilter) {
		List<E> result = new ArrayList();
		for(E ele : list) {
			boolean flag = listFilter.filter(ele);
			if(flag)
				result.add(ele);
		}
		return result;
	}

	public static <E,K> K reduce(List<E> list, ListReducer<E,K> reducer, K initial){
		K value =initial;
		for(E ele :list){
			value = reducer.compare(value,ele);
		} 
		return value;
	}

}