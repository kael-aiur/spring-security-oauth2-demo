package bingoee.sso.demo.security.servlet;

import bingoee.sso.demo.security.Clients;
import net.bingosoft.oss.ssoclient.SSOClient;
import net.bingosoft.oss.ssoclient.servlet.AbstractLogoutServlet;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kael.
 */
public class LogoutServlet extends AbstractLogoutServlet {
    @Override
    protected SSOClient getClient(ServletConfig config) throws ServletException {
        return Clients.getOrInt(config);
    }

    @Override
    protected void localLogout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SecurityContextHolder.clearContext();
    }
}
