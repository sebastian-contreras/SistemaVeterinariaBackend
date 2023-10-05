package com.sebastianContreras.SistemaVeterinaria.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sebastianContreras.SistemaVeterinaria.entities.enumeraciones.Roles;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "credenciales")
public class Credenciales  implements UserDetails {
    @Id
    @Column(unique = true)
    private String personasDni;

    @Column(unique = true)
    private String usuario;
    @Column(columnDefinition = "CHAR(60)")
    private String password;
    @Column(columnDefinition = "INT(1)")
    @Enumerated(value = EnumType.ORDINAL)
    private Roles rol;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Personas personas;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_".concat(rol.name())));
    }

    @Override
    public String getUsername() {
        return usuario;
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
