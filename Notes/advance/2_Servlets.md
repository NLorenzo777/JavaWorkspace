# Servlets [↑](../../README.md#advanced-java-fundamentals)
- A Java servlet is a Java class whose sole purpose is to receive a network request and response object (typically HTTP) and construct the necessary response.
- This allows to create dynamic responses (like a dynamic webpage) based on a request sent by a client.
- Makes it easy to create web applications incorporated with all the benefits of Java, like **portability** and **security**

### Example implementation
```java
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Annotation to define URL pattern (e.g., http://localhost:8080/hello)
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Set the content type (HTML response)
        response.setContentType("text/html");
        
        // Get writer to send response to client
        PrintWriter out = response.getWriter();
        
        // Write response
        out.println("<html><body>");
        out.println("<h1>Hello, Welcome to Servlet Example!</h1>");
        
        // Example of reading query parameters (e.g., ?name=Noel)
        String name = request.getParameter("name");
        if (name != null && !name.trim().isEmpty()) {
            out.println("<p>Hello, " + name + "!</p>");
        } else {
            out.println("<p>Please provide your name in the query string.</p>");
        }
        
        out.println("</body></html>");
    }
}
```