package kls.auth.server.model.sql;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor
@EqualsAndHashCode @ToString
public final class User implements UserDetails {
    private final String userName;
    private final String password;
    private final Boolean isAccountExpired;
    private final Boolean isAccountNonLocked;
    private final Boolean isCredentialsNonExpired;
    private final Boolean isEnabled;
    private final Collection<? extends GrantedAuthority> authorities;
    private final AdditionalUserInformation additionalUserInformation;

    public User(String userName) {
        this.userName = userName;
        this.password = null;
        this.isAccountExpired = null;
        this.isAccountNonLocked = null;
        this.isCredentialsNonExpired = null;
        this.isEnabled = null;
        this.authorities = null;
        this.additionalUserInformation = null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities!= null ? Collections.unmodifiableCollection(this.authorities) : null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return Boolean.TRUE.equals(this.isAccountExpired);
    }

    @Override
    public boolean isAccountNonLocked() {
        return Boolean.TRUE.equals(this.isAccountNonLocked);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return Boolean.TRUE.equals(this.isCredentialsNonExpired);
    }

    @Override
    public boolean isEnabled() {
        return Boolean.TRUE.equals(this.isEnabled);
    }

    public AdditionalUserInformation getAdditionalUserInformation() {
        return additionalUserInformation;
    }
}
