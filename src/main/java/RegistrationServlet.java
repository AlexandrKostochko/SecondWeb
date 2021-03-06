import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/reg")
public class RegistrationServlet extends HttpServlet {
    private final InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (name != null && login != null && password != null) {
            if (name.length() >= 2 && login.length() >= 2 && password.length() >= 2) {
                if(inMemoryUserStorage.reg(login)) {
                    User user = new User(name, login, password);
                    req.setAttribute("message", "Registration complete");
                    inMemoryUserStorage.save(user);
                } else {
                    req.setAttribute("message", "login exists");
                }
            } else {
                req.setAttribute("message", "Incorrect data, your name or login or password do not contain two symbols");
            }
        } else {
            req.setAttribute("message", "You aren't write name or login or password");
        }
        req.getServletContext().getRequestDispatcher("/reg.jsp").forward(req, resp);
    }
}
