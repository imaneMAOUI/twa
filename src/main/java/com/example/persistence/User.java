package com.example.persistence;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "username", nullable = false, unique = true, length = 60)
    private String username;

    @Column(name = "password", nullable = false, length = 60)
    private String password;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    // private boolean tokenExpired;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Authorities> authorities;
    
    
    //custom relationships
    
	@OneToMany(mappedBy="user")
	private List<Commande> commandes;
	
	
    public User() {
        this.authorities = new HashSet<Authorities>();
    }

    public User(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.authorities = new HashSet<Authorities>();
    }

    public User(String username, String password, boolean enabled,
            Set<Authorities> userRoles) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        if (userRoles != null) {
            this.authorities = userRoles;
        } else {
            this.authorities = new HashSet<Authorities>();
        }
    }

    public void addAuthorities(Authorities role) {
        this.authorities.add(role);
        if (role.getUser() != this) {
            role.setUser(this);
        }
    }

    public void addAuthorities(String role, User user) {
        this.addAuthorities(new Authorities(user, role));
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Authorities> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authorities> authorities) {
		this.authorities = authorities;
	}
    
}
