package ${package}.js;

import net.java.html.js.JavaScriptBody;

public final class JSFunctions {
    private JSFunctions() {
    }
    
#if ($example == "1")
    /** Shows confirmation dialog to the user.
     * 
     * @param msg the message
     * @param callback called back when the use accepts (can be null)
     * @return true or false
     */
    /** Shows direct interaction with JavaScript */
    @JavaScriptBody(
        args = { "msg", "callback" }, 
        javacall = true, 
        body = "if (confirm(msg)) {\n"
             + "  callback.@java.lang.Runnable::run()();\n"
             + "}\n"
    )
    public static native void confirmByUser(String msg, Runnable callback);
#end
}
