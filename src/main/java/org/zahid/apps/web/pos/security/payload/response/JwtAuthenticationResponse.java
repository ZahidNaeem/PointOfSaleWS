package org.zahid.apps.web.pos.security.payload.response;

public class JwtAuthenticationResponse {

  private String token;
  private String type = "Bearer";

  public JwtAuthenticationResponse(String accessToken) {
    this.token = accessToken;
  }

  public String getAccessToken() {
    return token;
  }

  public void setAccessToken(String accessToken) {
    this.token = accessToken;
  }

  public String getTokenType() {
    return type;
  }

  public void setTokenType(String tokenType) {
    this.type = tokenType;
  }
}
