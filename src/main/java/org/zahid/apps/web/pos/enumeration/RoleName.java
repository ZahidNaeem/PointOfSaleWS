package org.zahid.apps.web.pos.enumeration;

import java.util.Arrays;
import org.zahid.apps.web.pos.exception.RoleNameNotFoundException;

public enum RoleName {
  ROLE_USER("roleUser"),
  ROLE_PM("rolePm"),
  ROLE_ADMIN("roleAdmin");

  private String value;

  RoleName(final String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public RoleName fromValue(final String value) {
    return Arrays.stream(RoleName.values())
        .filter(role -> value.equals(role)).findFirst().orElseThrow(
            () -> new RoleNameNotFoundException("Role with value '" + value + "' not found"));
  }
}
