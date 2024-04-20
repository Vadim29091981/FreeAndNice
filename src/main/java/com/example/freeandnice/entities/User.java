package com.example.freeandnice.entities;

import com.example.freeandnice.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "_user")
public class User implements UserDetails { // make our app User a spring security User
/*
    we have two options : implements the UserDetails interface or create a user class that extends User spring class which also
    implements UserDetails
 */
    @Id
    @GeneratedValue
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String activationCode;
    private String phoneNumber;
    @OneToOne(mappedBy = "user")
    @JoinColumn(name = "file_data_id", referencedColumnName = "id")
    private FileData fileData;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String username, String lastname, String password)
    {
        firstname = username;
        this.lastname = lastname;
        this.password = password;

    }
    // we should return a list of roles
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
