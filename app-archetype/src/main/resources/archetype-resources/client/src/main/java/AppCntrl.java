package ${package};

#if ($example == "1")
import ${package}.js.JSFunctions;
#end
import net.java.html.json.Function;
import net.java.html.json.Model;
import net.java.html.json.Property;

@Model(className = "AppModel", targetId="", properties = {

  /* Application's ViewModel properties */
#if ($example == "1")
  @Property(name = "FirstName", type = String.class),
  @Property(name = "Message", type = String.class),
#end
})
public class AppCntrl {
    
    static AppModel model = null;
    
    /* Application's ViewModel methods */
#if ($example == "1")
    @Function static void sayHello(AppModel m) {
        m.setMessage("Hello, "+m.getFirstName()+"!");
    }
    
    @Function static void sayHi(final AppModel m) {
        // This code shows direct interaction with JavaScript.
        // The implementation of confirmByUser is in JavaScript Libraries project.
        
        JSFunctions.confirmByUser("Say hi?", new Runnable() {
            @Override
            public void run() {
              m.setMessage("Hi, "+m.getFirstName()+"!");
            }
        });
    }
#end

    public static void onPageLoad() throws Exception {
        model = new AppModel();
        
        /* Initialization of application's ViewModel values */
#if ($example == "1")
        model.setFirstName("John");
#end

        model.applyBindings();
    }
}