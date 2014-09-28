package ${package};

import net.java.html.boot.BrowserBuilder;

public final class Main {
    
    private Main() {
    }
    
    public static void main(String... args) throws Exception {
        BrowserBuilder.newBrowser().          
            loadPage("pages/index.html").
            loadClass(AppCntrl.class).
            invoke("onPageLoad").
            showAndWait();
        System.exit(0);
    }
}
