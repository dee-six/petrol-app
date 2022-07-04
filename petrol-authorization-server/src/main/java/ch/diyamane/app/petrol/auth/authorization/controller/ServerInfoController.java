package ch.diyamane.app.petrol.auth.authorization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.boot.actuate.metrics.MetricsEndpoint.ListNamesResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerInfoController {

  @Autowired
  MetricsEndpoint metricsEndpoint;

  @GetMapping("/api/server/info")
  public ResponseEntity<ListNamesResponse> getServerInfo() {
    return ResponseEntity.ok(metricsEndpoint.listNames());
  }
}
