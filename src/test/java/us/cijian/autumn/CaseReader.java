package us.cijian.autumn;

import org.junit.Test;
import us.cijian.autumn.model.Resource;

import java.io.IOException;

/**
 * Created by Murphy on 2/15/2015.
 */
public class CaseReader {

    /**
     *
     */
    @Test
    public void test() throws IOException{
        String res = Resource.get(Resource.HTML5_TEMPLATE);
        System.out.println(res);
    }

}
