package com.fullcourtfiesta.playerservice.domain;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Player implements UserDetails {

  @Id
  private Long id;

  private String email;
  private String username;
  @Column("full_name")
  private String fullName;
  private String password;

  @Column("created_at")
  private LocalDateTime createdAt;
  @Column("updated_at")
  private LocalDateTime updatedAt;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {

    return null;
  }

  @Override
  public String getUsername() {

    return id.toString();
  }

  @Override
  public boolean isAccountNonExpired() {

    return false;
  }

  @Override
  public boolean isAccountNonLocked() {

    return false;
  }

  @Override
  public boolean isCredentialsNonExpired() {

    return false;
  }

  @Override
  public boolean isEnabled() {

    return false;
  }
}