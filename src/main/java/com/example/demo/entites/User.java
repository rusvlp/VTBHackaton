package com.example.demo.entites;

import com.example.demo.enums.Role;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "user")
public class User implements UserDetails {
    public boolean getEmail;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email = "";

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "firstName")
    private String firstName = "";

    @Column(name = "lastName")
    private String lastName = "";

    @Column(name = "middleName")
    private String middleName = "";

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Image avatar;

    @Column(name = "jobTitle")
    private String jobTitle = "";

    @Column(name = "dateOfBirth")
    private LocalDateTime dateOfBirth = LocalDateTime.now();

    @Column(name = "roubleBalance")
    private Long roubleBalance = 0L;
    
    @Column(name = "cryptoBalance")
    private Long cryptoBalance = 0L;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Department department;

    @Column(name = "dateOfCreate")
    private LocalDateTime dateOfCreate;

    @ToString.Exclude
    @ManyToMany(mappedBy = "participantList", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Event> events;
    @PrePersist
    private void init(){
        dateOfCreate = LocalDateTime.now();
    }

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)

    private Set<Role> roles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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
