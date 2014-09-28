package ${package};

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class AppModelTest {
    @Test public void SayHelloTest() {
        AppModel model = new AppModel();
#if ($example == "true")
        model.setFirstName("John");
        AppCntrl.SayHello(model);
        assertEquals("Hello, John!", model.getMessage(), "John is pleased");        
#end        
    }
}
