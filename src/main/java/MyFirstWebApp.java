import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.PrintWriter;

import java.io.IOException;

public class MyFirstWebApp extends GenericServlet {


    @Override
    public void service(ServletRequest req , ServletResponse res) throws ServletException, IOException {
       //ab isme content kaise likhte
        // ab ja bhu aap request karoge apne browser , to wo servlet reqs , response karga  to servlet response
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h2> Hello from genie ashwani </h2");
        
    }
 }
