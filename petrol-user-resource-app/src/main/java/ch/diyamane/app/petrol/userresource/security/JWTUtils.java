package ch.diyamane.app.petrol.userresource.security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import java.util.Date;
import javax.crypto.SecretKey;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class JWTUtils {

  @Autowired
  SecretKeyHolder secretKeyHolder;

  @Value("${jwt.user.bec.jwtSecret}")
  String jwtSecret;

  @Value("${jwt.user.bec.jwtExpirationMs}")
  int jwtExpirationMs;

  public String generateJwtToken(Authentication authentication) {

    UserDetails principle = (UserDetails) authentication.getPrincipal();

    return Jwts.builder()
        .setSubject((principle.getUsername()))
        .setIssuedAt(new Date())
        .setExpiration(DateUtils.addMilliseconds(new Date(), jwtExpirationMs))
        .signWith(secretKeyHolder.getKey())
        .compact();
  }

  public String generateJwtToken(Mono<Authentication> authentication) {

    Mono<String> what = authentication.map(authentication1 -> {
      UserDetails principle = (UserDetails) authentication1.getPrincipal();

      return Jwts.builder()
          .setSubject((principle.getUsername()))
          .setIssuedAt(new Date())
          .setExpiration(DateUtils.addMilliseconds(new Date(), jwtExpirationMs))
          .signWith(secretKeyHolder.getKey())
          .compact();
    }).switchIfEmpty(Mono.error(new Exception("JTW Token generation failed.")));

    return what.toString();

  }

  public String getUserName(String jwtToken) {
    return (String) Jwts.parserBuilder().setSigningKey(secretKeyHolder.getKey()).build().parseClaimsJws(jwtToken).getBody()
        .getSubject();
  }

  public boolean validateJwtToken(String authToken) {
    try {
      Jwts.parserBuilder().setSigningKey(secretKeyHolder.getKey()).build().parseClaimsJws(authToken);
      return true;
    } catch (SignatureException e) {
      log.error("Invalid JWT signature: {}", e.getMessage());
    } catch (MalformedJwtException e) {
      log.error("Invalid JWT token: {}", e.getMessage());
    } catch (ExpiredJwtException e) {
      log.error("JWT token is expired: {}", e.getMessage());
    } catch (UnsupportedJwtException e) {
      log.error("JWT token is unsupported: {}", e.getMessage());
    } catch (IllegalArgumentException e) {
      log.error("JWT claims string is empty: {}", e.getMessage());
    }

    return false;
  }
}
