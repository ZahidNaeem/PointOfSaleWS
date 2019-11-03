package org.zahid.apps.web.pos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GmailCredentials {
    private final String userEmail;
    private final String clientId;
    private final String clientSecret;
    private final String accessToken;
    private final String refreshToken;
}
