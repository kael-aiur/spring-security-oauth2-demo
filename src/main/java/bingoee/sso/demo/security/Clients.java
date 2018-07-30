package bingoee.sso.demo.security;

import net.bingosoft.oss.ssoclient.SSOClient;
import net.bingosoft.oss.ssoclient.SSOConfig;
import net.bingosoft.oss.ssoclient.internal.HttpClient;

import javax.servlet.ServletConfig;

/**
 * @author kael.
 */
public final class Clients {
    public static SSOClient client = null;
    
    private Clients(){
        throw new RuntimeException("not allow to instance.");
    }
    
    public static void init(ServletConfig servletConfig){
        if(null != client){
            return;
        }
        HttpClient.ignoreHttpsCer();
        SSOConfig config = new SSOConfig();
        // todo: 请联系管理员申请应用id
        config.setClientId("testclient1");
        // todo: 请联系管理员申请应用密钥
        config.setClientSecret("testclient2");
        config.setDefaultReturnUrl(servletConfig.getServletContext().getContextPath()+"/index");
        // 这个地址需要在应用注册的时候填写
        String redirectUri = servletConfig.getServletContext().getContextPath()+"/ssoclient/login";
        config.setRedirectUri(redirectUri);
        String sso = servletConfig.getInitParameter("ssoUrl");
        config.autoConfigureUrls(sso);
        // todo: 本地应用注销地址
        config.setLogoutUri("http://localhost:8080/security/ssoclient/logout");
        client = new SSOClient(config);
    }
    
    public static SSOClient getOrInt(ServletConfig servletConfig){
        if(null == client){
            init(servletConfig);
        }
        return client;
    }
    
}
