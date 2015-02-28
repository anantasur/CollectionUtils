import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

class IntegerMapper implements ListMapper<Integer> {
   public Integer mapper(Integer element){
       return element*element;
   }
}

class StringMapper implements ListMapper<String> {
   public String mapper(String element){
       return element.toLowerCase();
   }
}

class EvenFilter implements ListFilter<Integer> {
  public boolean filter (Integer element){
    return (element.intValue() % 2 == 0);
  }
}

public class CollectionUtilsTest{

  @Test
  public void test_1_plus_1_is_2 (){
    assertEquals(2,1+1);
  }

  @Test
  public void map_returns_an_Integer_List_after_Sqauring_on_the_given_list(){
    ListMapper listMapper = new IntegerMapper();
    List<Integer> numbers = new ArrayList<Integer>();
    List<Integer> expected = new ArrayList<Integer>();

    numbers.add(1);
    numbers.add(2);
    numbers.add(3);

    expected.add(1);
    expected.add(4);
    expected.add(9);

    List<Integer> result = CollectionUtils.<Integer>map(numbers,listMapper);
    assertEquals(expected.get(0),result.get(0));
    assertEquals(expected.get(1),result.get(1));
  }

  @Test
  public void map_returns_a_String_List_after_lowerCasing_on_the_given_list(){
    ListMapper listMapper = new StringMapper();
    List<String> names = new ArrayList<String>();
    List<String> expected = new ArrayList<String>();
    
    names.add("BOB");
    names.add("AlicE");

    expected.add("bob");
    expected.add("alice");

    List<String> result = CollectionUtils.<String>map(names,listMapper);
    assertEquals(expected.get(0),result.get(0));
    assertEquals(expected.get(1),result.get(1));
  }

  @Test
  public void filter_returns_an_Integer_List_after_filtering_evens_from_the_given_list(){
    ListFilter listFilter = new EvenFilter();
    List<Integer> names = new ArrayList<Integer>();
    List<Integer> expected = new ArrayList<Integer>();
    
    names.add(1);
    names.add(2);
    names.add(4);
    names.add(9);

    expected.add(2);
    expected.add(4);

    List<Integer> result = CollectionUtils.<Integer>filter(names,listFilter);
    assertEquals(expected.get(0),result.get(0));
    assertEquals(expected.get(1),result.get(1));
  }

}