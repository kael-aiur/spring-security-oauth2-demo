package bingoee.sso.demo.security;

import net.bingosoft.oss.ssoclient.model.AccessToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author kael.
 */
public class OAuth2Authentication implements Authentication {
    private net.bingosoft.oss.ssoclient.model.Authentication authc;
    private AccessToken token;
    private List<GrantedAuthority> authorities;
    public OAuth2Authentication(net.bingosoft.oss.ssoclient.model.Authentication authc, AccessToken token) {
        this.authc = authc;
        this.token = token;
        authorities = new ArrayList<>();
        if(authc.getScope() != null && !authc.getScope().isEmpty()){
            String[] scopes = authc.getScope().split(" ");
            for(String s : scopes){
                authorities.add(new SimpleGrantedAuthority(s));
            }
        }
    }

    public net.bingosoft.oss.ssoclient.model.Authentication getAuthc() {
        return authc;
    }

    public void setAuthc(net.bingosoft.oss.ssoclient.model.Authentication authc) {
        this.authc = authc;
    }

    public AccessToken getToken() {
        return token;
    }

    public void setToken(AccessToken token) {
        this.token = token;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Object getCredentials() {
        return authc;
    }

    @Override
    public Object getDetails() {
        return authc;
    }

    @Override
    public Object getPrincipal() {
        return authc;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }

    @Override
    public String getName() {
        return authc.getUsername();
    }
}
