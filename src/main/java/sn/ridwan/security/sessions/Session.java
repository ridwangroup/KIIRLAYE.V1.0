package sn.ridwan.security.sessions;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;

@ApplicationScoped
public class Session extends HttpServlet {

    @Override
    public void init() {
        // ...
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            String sessionId = session.getId();
            // Use the session object to store and retrieve state information
        } else {
            session = request.getSession(true);
            String sessionId = session.getId();
            // Send the session token back to the client
            response.addCookie(new Cookie("SESSIONID", sessionId));
            // Use the session object to store and retrieve state information
        }
    }
}
