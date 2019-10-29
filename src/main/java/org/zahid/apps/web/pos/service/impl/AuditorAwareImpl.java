package org.zahid.apps.web.pos.service.impl;

import java.util.Optional;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.zahid.apps.web.pos.entity.User;
import org.zahid.apps.web.pos.security.service.UserPrincipal;

public class AuditorAwareImpl implements AuditorAware<User> {

    @Override
    public Optional<User> getCurrentAuditor() {
//        return Optional.of("Zahid");
        // Can use Spring Security to return currently logged in user
        // return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null ||
                !authentication.isAuthenticated() ||
                authentication instanceof AnonymousAuthenticationToken) {
            return Optional.empty();
        }

        final UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        final User user = new User(
                userPrincipal.getName(),
                userPrincipal.getUsername(),
                userPrincipal.getEmail(),
                userPrincipal.getPassword(),
                userPrincipal.getOrganization()
                );

        return Optional.ofNullable(user);
    }
}

/*
public class AuditorAwareImpl implements AuditorAware<User> {

  public Optional<User> getCurrentAuditor() {

    return Optional.ofNullable(SecurityContextHolder.getContext())
        .map(SecurityContext::getAuthentication)
        .filter(Authentication::isAuthenticated)
        .map(Authentication::getPrincipal)
        .map(User.class::cast);
  }
}*/
