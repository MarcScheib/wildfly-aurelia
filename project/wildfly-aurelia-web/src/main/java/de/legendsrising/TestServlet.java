package de.legendsrising;

import de.legendsrising.servlet.qualifier.DefaultValue;
import de.legendsrising.servlet.qualifier.RequestParam;
import org.slf4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet"})
public class TestServlet extends HttpServlet
{
    private static final long serialVersionUID = -7238481086155456650L;

    @Inject
    protected Logger logger;

    @Inject
    @RequestParam
    @DefaultValue("250")
    private Instance<String> id;

    @Override
    protected final void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        try (ServletOutputStream outputStream = response.getOutputStream())
        {
            outputStream.write("hmmm".getBytes("UTF-8"));
            outputStream.write(this.id.get().getBytes("UTF-8"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
