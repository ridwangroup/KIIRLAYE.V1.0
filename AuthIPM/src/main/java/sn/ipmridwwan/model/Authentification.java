package sn.ipmridwwan.model;

public class Authentification{
    private long id;
    private String username;
    private String password;
    /*public Object login(HttpServletRequest req, HttpServletResponse res)
            throws ServletException {

        PrintWriter out = null;
        try {
            out =  res.getWriter();
            res.setContentType("text/html");
        } catch (java.io.IOException e){
            // Error handling
        }

        Subject subject = null;
        try {
            LoginContext lc = new LoginContext("system.Your_login_configuration",
                    WSCallbackHandlerFactory.getInstance().getCallbackHandler(
                            userid, null, password, req, res, null));
            lc.login();
            subject = lc.getSubject();
            WSSubject.setRunAsSubject(subject);
        } catch(Exception e) {
            // catch all possible exceptions if you want or handle them separately
            out.println("Exception in LoginContext login + Exception = " +
                    e.getMessage());
            throw new ServletException(e.getMessage());
        }

        The following is sample code to revoke the SSO cookies upon a programming logout:


        The LogoutServlet.java:

        public void logout(HttpServletRequest req, HttpServletResponse res,
                Object retCreds)  throws ServletException {
            PrintWriter out =null;
            try {
                out =  res.getWriter();
                res.setContentType("text/html");
            } catch (java.io.IOException e){
                // Error Handling
            }
            try {
                WSSecurityHelper.revokeSSOCookies(req, res);
            } catch(Exception e) {
                // catch all possible exceptions if you want or handle them separately
                out.println("JAASLogoutServlet: logout Exception = " + e.getMessage());
                throw new ServletException(e);
            }
        }*/

}
