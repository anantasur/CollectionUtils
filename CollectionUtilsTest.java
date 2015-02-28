import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

class IntUtil implements ListMapper<Integer,String>, ListFilter<Integer>, ListReducer<Integer,Integer>{
  public String map(Integer element){
    return ""+(element *2);
  }
  public boolean filter(Integer element){
    return element%2==0;
  }
  public Integer compare(Integer previousVal,Integer currentVal){
    return previousVal+currentVal;
  }

}

public class CollectionUtilsTest{

  @Test
  public void test_1_plus_1_is_2 (){
    assertEquals(2,1+1);
  }

  @Test
  public void map_retuns_listOf_maped_element(){
    IntUtil iu= new IntUtil();
    String expected [] ={"2","4","6","8","10"};
    List<Integer> list =new  ArrayList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);

    List<String> mapList =CollectionUtils.<Integer,String>map(list,iu);
    assertEquals(mapList.toArray(),expected);
    assertEquals(mapList.size(),list.size());
  }

  @Test
  public void filter_returns_an_Integer_List_after_filtering_evens_from_the_given_list(){
    IntUtil iu= new IntUtil();
    List<Integer> names = new ArrayList<Integer>();
    List<Integer> expected = new ArrayList<Integer>();
    
    names.add(1);
    names.add(2);
    names.add(4);
    names.add(9);

    expected.add(2);
    expected.add(4);

    List<Integer> result = CollectionUtils.<Integer>filter(names,iu);
    assertEquals(expected.get(0),result.get(0));
    assertEquals(expected.get(1),result.get(1));
  }
  @Test
  public void reduce_retuns_one_element(){
    IntUtil iu= new IntUtil();
    Integer expected =15;
    List<Integer> list =new  ArrayList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);

    Integer l =CollectionUtils.<Integer,Integer>reduce(list,iu,0);
    assertEquals(l.intValue(),15);
  }
}