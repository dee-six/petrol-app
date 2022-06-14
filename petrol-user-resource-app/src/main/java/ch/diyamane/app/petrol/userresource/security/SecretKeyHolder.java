package ch.diyamane.app.petrol.userresource.security;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Getter
@Slf4j
@NoArgsConstructor
public class SecretKeyHolder {

  private SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

}
