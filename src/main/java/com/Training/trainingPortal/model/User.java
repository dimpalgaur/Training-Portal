package com.Training.trainingPortal.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.Training.trainingPortal.model.Role;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class User implements UserDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String uName;
    private String email;
    private String password;
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //as one user can have many role and one role can assign to many users
    //below query we are creating to create new table by joining two tables
    
    @JoinTable(name="User_role", joinColumns = @JoinColumn(name="user", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name="role", referencedColumnName = "id"))//here we telling that id is a foreign Key)
    private Set<Role> roles = new HashSet<>();

//    Above join query having meaning like this
//    CREATE TABLE `user_role` (
//    		  `user` int NOT NULL,
//    		  `role` int NOT NULL,
//    		  PRIMARY KEY (`user`,`role`),
//    		  KEY `FK26f1qdx6r8j1ggkgras9nrc1d` (`role`),
//    		  CONSTRAINT `FK26f1qdx6r8j1ggkgras9nrc1d` FOREIGN KEY (`role`) REFERENCES `role` (`id`),
//    		  CONSTRAINT `FKmow7bmkl6wduuutk26ypkgmm1` FOREIGN KEY (`user`) REFERENCES `user` (`id`)
//    		)
    
	/*
	 * In CustomUserDeatilsService we have return type userDetails but in implementation we are getting result as 
	 * a User class type that's why we are mapping or converting the object user in userDeatil (in below code by 
	 * implements UserDetails in User class and override the methods) after that we can return user even if our return 
	 * type is userDeatils in CustomUserDeatilsService.
	 */
    
    @Override
	public Collection<? extends GrantedAuthority> getAuthorities() 
    {
        List<SimpleGrantedAuthority> authorities = this.roles.stream().map((role) -> new SimpleGrantedAuthority(role.getUname())).collect(Collectors.toList());
		return authorities;
	}

	@Override
	public String getPassword() 
	{
		return this.password;
	}

	@Override
	public String getUsername() 
	{
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() 
	{
		return true;
	}

	@Override
	public boolean isAccountNonLocked() 
	{	
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() 
	{	
		return true;
	}

	@Override
	public boolean isEnabled() 
	{	
		return true;
	}
    
    
}
