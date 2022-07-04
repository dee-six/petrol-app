package ch.diyamane.app.petrol.auth.authorization.domain;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "CLIENT")
@Data
public class Client {

  @Id
  private String id;

  private String clientId;

  private Instant clientIdIssuedAt;

  private String clientSecret;

  private Instant clientSecretExpiresAt;

  private String clientName;

  @Column(length = 1000)
  private String clientAuthenticationMethods;

  @Column(length = 1000)
  private String authorizationGrantTypes;

  @Column(length = 1000)
  private String redirectUris;

  @Column(length = 1000)
  private String scopes;

  @Column(length = 2000)
  private String clientSettings;

  @Column(length = 2000)
  private String tokenSettings;

}