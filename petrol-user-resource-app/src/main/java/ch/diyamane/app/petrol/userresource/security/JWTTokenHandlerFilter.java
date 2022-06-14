package ch.diyamane.app.petrol.userresource.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class JWTTokenHandlerFilter implements WebFilter {

    @Autowired
    JWTTokenService jwtTokenService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

        log.debug("Filter reached");

        String headerAuth = exchange.getRequest().getHeaders().getFirst("Authorization");
        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            log.debug("JWT token is provided");
            String jwtToken = headerAuth.substring(7, headerAuth.length());

            jwtTokenService.validateJwtToken(jwtToken);

        }
         return chain.filter(exchange);
    }
}