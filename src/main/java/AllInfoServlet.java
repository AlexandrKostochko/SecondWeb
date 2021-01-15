import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/allInfo")
public class AllInfoServlet extends HttpServlet {
    private final InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getServletContext().getRequestDispatcher("/allInfo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!inMemoryUserStorage.getIdUser()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < inMemoryUserStorage.getInfo().size(); i++) {
                stringBuilder.append("name - " + inMemoryUserStorage.getInfo().get(i).getName() +
                        ", login - " + inMemoryUserStorage.getInfo().get(i).getLogin() +
                        ", password - " + inMemoryUserStorage.getInfo().get(i).getPassword() +
                        ", id - " + inMemoryUserStorage.getInfo().get(i).getUserid() + "<br>");
            }
            req.setAttribute("message", stringBuilder.toString());
        } else {
            req.setAttribute("message", "no registered users");
        }
        req.getServletContext().getRequestDispatcher("/allInfo.jsp").forward(req, resp);
    }
}
