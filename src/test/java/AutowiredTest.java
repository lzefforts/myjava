import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.study.spring.MyBean;

/**
 * Created by ArnoldLee on 18/3/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AutowiredTest {

    @Autowired
    private MyBean myBean;

    @Test
    public void testLoad(){
        System.out.println("###########");
        System.out.println(myBean.getTestStr());
    }


}
