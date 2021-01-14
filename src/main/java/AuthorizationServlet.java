import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/auth")
public class AuthorizationServlet extends HttpServlet {

    private final InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/authorization.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User byLogin = inMemoryUserStorage.getByLogin(login);
        if (byLogin != null) {
            if (password.equals(byLogin.getPassword())) {
                req.getSession().setAttribute("user", byLogin);
                req.setAttribute("message", "Authorization complete");
            } else {
                req.setAttribute("message", "incorrect password");
            }
        } else {
            req.setAttribute("message", "incorrect login");
        }
        req.getServletContext().getRequestDispatcher("/authorization.jsp").forward(req, resp);
    }
}
