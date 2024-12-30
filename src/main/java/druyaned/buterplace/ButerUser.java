package druyaned.buterplace;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Table
public class ButerUser implements UserDetails {
    
    private static final long serialVersionUID = 1L;
    
    @Id private Long id;
    private final String username;
    private final String password;
    private final String name;
    private final String address;
    private final String phoneNumber;
    
    public ButerUser(
            String username,
            String password,
            String name,
            String address,
            String phoneNumber
    ) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    @Override public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }
    
    @Override public String getUsername() {
        return username;
    }
    
    @Override public String getPassword() {
        return password;
    }
    
    @Override public boolean isAccountNonExpired() {
        return true;
    }
    
    @Override public boolean isAccountNonLocked() {
        return true;
    }
    
    @Override public boolean isCredentialsNonExpired() {
        return true;
    }
    
    @Override public boolean isEnabled() {
        return true;
    }
    
    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Override public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.id);
        hash = 73 * hash + Objects.hashCode(this.username);
        hash = 73 * hash + Objects.hashCode(this.password);
        hash = 73 * hash + Objects.hashCode(this.name);
        hash = 73 * hash + Objects.hashCode(this.address);
        hash = 73 * hash + Objects.hashCode(this.phoneNumber);
        return hash;
    }
    
    @Override public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ButerUser other = (ButerUser) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.phoneNumber, other.phoneNumber)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
    
    @Override public String toString() {
        return "ButerUser{id=" + id
                + ", username=" + username
                + ", password=" + password
                + ", name=" + name
                + ", address=" + address
                + ", phoneNumber=" + phoneNumber
                + '}';
    }
    
}
