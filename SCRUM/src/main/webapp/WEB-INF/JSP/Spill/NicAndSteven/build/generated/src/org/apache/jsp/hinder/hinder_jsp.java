package org.apache.jsp.hinder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class hinder_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Hinder</title>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../felles/style.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"hinder.css\">\n");
      out.write("        <script src=\"hinder_side.js\"></script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div id=\"spill\">\n");
      out.write("            \n");
      out.write("            <form id=\"formen\" action=\"../kart/kart.jsp\" method=\"POST\">\n");
      out.write("                <input id=\"bane\" type=\"hidden\" name=\"bane\" value=\"\" />\n");
      out.write("                <input id=\"poeng\" type=\"hidden\" name=\"poeng\" value=\"\" />\n");
      out.write("            </form>\n");
      out.write("        \n");
      out.write("        <section id=\"content\">\n");
      out.write("\n");
      out.write("            <section class=\"block\">\n");
      out.write("                \n");
      out.write("                <div id=\"oppgavetekst\">\n");
      out.write("                    Her er det noe som er fryktelig galt. <br>\n");
      out.write("                    Steven har kludret med html-koden slik at den ikke henger sammen med css-en. <br>\n");
      out.write("                    Her skal det være en vei som Nic kan følge. Fiks html-koden slik at den passer med css-en.\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div id =\"container\">\n");
      out.write("                    <span id=\"timer\"></span>\n");
      out.write("                    <div id=\"soppel\">\n");
      out.write("                        <img src=\"../bilder/hinder.png\"/>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <canvas id=\"canvas\" >\n");
      out.write("                    <script src=\"hinder_spill.js\"></script>\n");
      out.write("                    <div id=\"box\"></div> \n");
      out.write("                </canvas>\n");
      out.write("\n");
      out.write("                <div id=\"codeContainer\">  \n");
      out.write("                    <section class=\"block\">        \n");
      out.write("                        <div class=\"litenoverskrift\">CSS</div>\n");
      out.write("                        <textarea class=\"codeBox\" id=\"cssView\"></textarea>\n");
      out.write("                    </section>\n");
      out.write("\n");
      out.write("                    <section class=\"block\">        \n");
      out.write("                        <div class=\"litenoverskrift\">HTML (kan ikke redigeres)</div>\n");
      out.write("                        <textarea readonly class=\"codeBox\" id=\"htmlView\"></textarea>\n");
      out.write("                    </section>\n");
      out.write("\n");
      out.write("                    <section class=\"block\" id=\"knapper\">    \n");
      out.write("                        <input type=\"button\" value=\"Oppdater\" id=\"viewResult\" />\n");
      out.write("                        <input type=\"button\" value=\"Tilbakestill\" id=\"reset\" />\n");
      out.write("                    </section>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("            </section>\n");
      out.write("            \n");
      out.write("        </section>\n");
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
