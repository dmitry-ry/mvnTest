package servlets;

import main.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by dmitry on 08.07.17.
 */
public class SignUpServlet extends HttpServlet {
    private final static String PASSWORD = "password";
    private final static String LOGIN = "login";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> allRqParameters = req.getParameterMap();
        String retMessage;
        if (allRqParameters.containsKey(PASSWORD) && allRqParameters.containsKey(LOGIN)) {
            AccountService accService = AccountService.getInstance();
            try {
                accService.register(allRqParameters.get(LOGIN)[0], allRqParameters.get(PASSWORD)[0]);
                retMessage = "User registered";
                resp.setStatus(HttpServletResponse.SC_OK);
            } catch (Exception e) {
                retMessage = e.getMessage();
                resp.setStatus(HttpServletResponse.SC_CONFLICT);
            }
        } else {
            retMessage = "Invalid request. Check parameters";
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        resp.getWriter().println(retMessage);
    }
}
