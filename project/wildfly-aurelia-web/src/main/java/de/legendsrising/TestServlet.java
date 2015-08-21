package de.legendsrising;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TestServlet", urlPatterns = { "/TestServlet" })
public class TestServlet extends HttpServlet
{
    private static final long serialVersionUID = -7238481086155456650L;

    private String id = "1";

    @Override
    public void service(ServletRequest req, ServletResponse res)
            throws ServletException, IOException
    {
        if (req instanceof HttpServletRequest)
        {
            Field[] fields = this.getClass().getDeclaredFields();
            for (Field f : fields)
            {
                if (!f.getName().equals("id")) continue;
                System.out.println(f.getName());
                try
                {
                    System.out.println(req.getParameterMap().get(f.getName())[0]);
                    f.set(this, req.getParameterMap().get(f.getName())[0]);
                }
                catch (IllegalAccessException e)
                {
                    e.printStackTrace();
                }

            }
        }

        super.service(req, res);
    }

    @Override
    protected final void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        try (ServletOutputStream outputStream = response.getOutputStream())
        {
            outputStream.write(this.id.getBytes("UTF-8"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
