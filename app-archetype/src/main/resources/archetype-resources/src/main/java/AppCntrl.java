package ${package};

import net.java.html.json.Function;
import net.java.html.json.Model;
import net.java.html.json.Property;
#if ($nbrwsr == "true")
import org.netbeans.api.nbrwsr.OpenHTMLRegistration;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
#end

@Model(className = "AppModel", properties = {

  /* Application's ViewModel properties */
#if ($example == "true")
  @Property(name = "FirstName", type = String.class),
  @Property(name = "Message", type = String.class),
#end
})
public class AppCntrl {
    
    static AppModel model = null;
    
    /* Application's ViewModel methods */
#if ($example == "true")
    @Function static void SayHello(AppModel m) {
      m.setMessage("Hello, "+m.getFirstName()+"!");
    }
#end

#if ($nbrwsr == "true")
    //
    // the following annotations generate registration for NetBeans,
    // they are harmless in other packaging schemes
    //

    @ActionID(
        category = "Applications",
        id = "${package}.OpenPage"
    )
    @OpenHTMLRegistration(
        url="index.html",
        displayName = "Open Your Page",
        iconBase = "${package.replace('.','/')}/icon.png"
    )
    @ActionReferences({
        @ActionReference(path = "Menu/Window"),
        @ActionReference(path = "Toolbars/Applications")
    })
    //
    // end of NetBeans actions registration
    //
#end
    public static void onPageLoad() throws Exception {
        model = new AppModel();
        
        /* Initialization of application's ViewModel values */
#if ($example == "true")
        model.setFirstName("John");
#end

        model.applyBindings();
    }
}