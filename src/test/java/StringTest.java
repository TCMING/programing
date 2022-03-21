import org.junit.Test;

public class StringTest {


    @Test
    public void testIndexOf(){
        String str = "aeiouAEIOU";
        System.out.println(str.indexOf('e'));
        System.out.println(str.indexOf('b'));
        System.out.println(str.indexOf('a'));
        System.out.println(str.indexOf('U'));

    }

}
