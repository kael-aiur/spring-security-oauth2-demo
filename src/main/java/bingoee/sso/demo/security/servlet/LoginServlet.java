package bingoee.sso.demo.security.servlet;

import bingoee.sso.demo.security.Clients;
import bingoee.sso.demo.security.OAuth2Authentication;
import net.bingosoft.oss.ssoclient.SSOClient;
import net.bingosoft.oss.ssoclient.model.AccessToken;
import net.bingosoft.oss.ssoclient.model.Authentication;
import net.bingosoft.oss.ssoclient.servlet.AbstractLoginServlet;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kael.
 */
public class LoginServlet extends AbstractLoginServlet {
    public static SSOClient client = null;
    
    @Override
    protected SSOClient getClient(ServletConfig servletConfig) throws ServletException {
        return Clients.getOrInt(servletConfig);
    }

    @Override
    protected void localLogin(HttpServletRequest req, HttpServletResponse resp, Authentication authc, AccessToken token) throws ServletException, IOException {
        SecurityContextHolder.getContext().setAuthentication(new OAuth2Authentication(authc,token));
    }
}
