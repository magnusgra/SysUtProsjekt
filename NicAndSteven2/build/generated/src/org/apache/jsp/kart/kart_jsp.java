package org.apache.jsp.kart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class kart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Kart</title>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../felles/style.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"kart.css\">\n");
      out.write("    </head>\n");
      out.write("        \n");
      out.write("    <body>\n");
      out.write("        ");
      org.geeks.Second myBean = null;
      synchronized (session) {
        myBean = (org.geeks.Second) _jspx_page_context.getAttribute("myBean", PageContext.SESSION_SCOPE);
        if (myBean == null){
          myBean = new org.geeks.Second();
          _jspx_page_context.setAttribute("myBean", myBean, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("myBean"), "bane", request.getParameter("bane"), request, "bane", false);
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("myBean"), "poeng", request.getParameter("poeng"), request, "poeng", false);
      out.write("\n");
      out.write("        ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((org.geeks.Second)_jspx_page_context.findAttribute("myBean")).getBane())));
      out.write("\n");
      out.write("        ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((org.geeks.Second)_jspx_page_context.findAttribute("myBean")).getPoeng())));
      out.write("\n");
      out.write("        \n");
      out.write("        ");

            int a = myBean.store();
        
      out.write("\n");
      out.write("        \n");
      out.write("        <div id=\"spill\">\n");
      out.write("        \n");
      out.write("            <section id=\"content\">\n");
      out.write("\n");
      out.write("                <section class=\"block\">\n");
      out.write("                    \n");
      out.write("                    <div id=\"oppgavetekst\">Velg brett!</div>\n");
      out.write("\n");
      out.write("                    <div id =\"container\"></div>\n");
      out.write("\n");
      out.write("                    <canvas id=\"canvas\" >\n");
      out.write("\n");
      out.write("                        <script src=\"kart.js\"></script>\n");
      out.write("                        <div id=\"box\"></div>\n");
      out.write("\n");
      out.write("                    </canvas>\n");
      out.write("                    \n");
      out.write("                </section>\n");
      out.write("                \n");
      out.write("                <div id=\"level\">\n");
      out.write("                        <p>Nic er på vei til audition.</p>\n");
      out.write("                        <p>Beveg Nic med piltastene.</p>\n");
      out.write("                        <br />\n");
      out.write("                        <a href=\"#\" id=\"start\">Start</a>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </section>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("    \n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
