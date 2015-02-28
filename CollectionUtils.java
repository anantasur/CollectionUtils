import java.util.*;

interface ListMapper<E> {
   E mapper(E element);
}

interface ListFilter<E> {
	boolean filter(E element);
}

public class CollectionUtils {

	public static<E> List<E> map(List<E> list, ListMapper listMapper) {
		List<E> result = new ArrayList();
		for(E ele : list) {
			E i = (E)listMapper.mapper(ele);
			result.add(i);
		}
		return result;
	}

	public static<E> List<E> filter(List<E> list, ListFilter listFilter) {
		List<E> result = new ArrayList();
		int index = 0;
		for(E ele : list) {
			boolean flag = listFilter.filter(ele);
			index++;
			if(flag)
				result.add(ele);
		}
		return result;
	}

}