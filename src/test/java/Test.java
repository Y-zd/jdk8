/***
 *
 * @author : yanzhidong
 * @date : 2020/4/22 
 * @version : V1.0
 *
 */
public class Test {

    public void test() {
        int j = 9;
        while ((j -= 2) > 0) ;
        System.out.println(j);
    }
    public static void main(String[] args) {
        Test test = new Test();
        for (int i = 0; i < 20_000; i++) {
            System.out.println("#"+i);
            test.test();
        }
    }
}