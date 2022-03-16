# Petrol Web Application
*   Functional : Web based application to determine which gas station is the best suitable for my car.
*   Technical  : Build Angular based SPA developed that communicates with a secured microservice architecture backend app via API (REST).
*   Finally, migrate this to be a mobile app.

# Design approach
* API first approach
  * Use Open API GIU to define an API to meet functional and technical
  * Generate Java API and DTO as well as TypeScript API and default CRUD services.
* Implement API and DTOs using spring-boot framework as secured resource application
  * Microservice architecture,cloud enabled - api gateway, discoverable, OAuth2 authenticated secured back end application


# Architecture Pattern

## Security on Cloud Gateway Pattern - oAuth Keycloak
### Components
| Component                                    | Function                                                                                                 | Port   |
|----------------------------------------------|----------------------------------------------------------------------------------------------------------|--------|
| ``AngularWebApp (keycloak-angular-web-app)`` | Provides signup, login to Keycloak authorization server and access token based access to secured content | 8081   |
| ``KeycloakDocker``                           | Authorization server - OpenID Connect based authentication and authorization                             | 8080   |
| ``Client-Gateway``                           | Spring cloud gateway based - routes, load balancers, security (authorization)                            | 8082   |
| ``Cloud-Discovery``                          | Spring Cloud Netflix based - service discovery                                                           | 8761   |
| ``User Manager Resource``                    | Spring boot web to manager users                                                                         | 8084   |
| ``Business Resource``                        | Spring boot web with security and serve security content                                                 | 8085   |
| ``Postgresql Docker``                        | Postgresql Docker is used by KeycloakDocker as a persistence store                                       | 5432   |

### Architecture
- ``AngularWebApp (keycloak-angular-web-app) --> Client-gateway--> Authentication (Keycloak)``
- ``AngularWebApp --> Client-Gateway--> Authorization (Keycloak)``
- ``AngularWebApp --> Client-Gateway--> Cloud-Descovery --> ResourceServer with Bearer token Jwt (Keycloak)``



# Junit 5 Based Tests

# Code Analysis Codacy
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/20beb1d7a9af4d7fb0164600a83f9a61)](https://app.codacy.com/gh/dee-six/petrol-app?utm_source=github.com&utm_medium=referral&utm_content=dee-six/petrol-app&utm_campaign=Badge_Grade_Settings)

# Synk
[![Known Vulnerabilities](https://snyk.io/test/github/dee-six/petrol-app/badge.svg)](https://snyk.io/test/github/dee-six/petrol-app/badge.svg)

# Code Inspector
[![Code Quality score](https://www.code-inspector.com/project/27224/score/svg)](https://www.code-inspector.com/project/27224/score/svg)
[![Code Grade ](https://www.code-inspector.com/project/27224/status/svg)](https://www.code-inspector.com/project/27224/status/svg)

#### References
*   Use Open API GUI <https://mermade.github.io/openapi-gui/> to define your API
*   Use Open API maven command to generate Java and Typescript code [Open API Generator Plugins](https://openapi-generator.tech/docs/plugins "Open API Generator Plugins") 
*   Use Travis CI for Countinous Integration [Travis CI](https://travis-ci.com/ "title") 

*   Use docker [Docker Hub](https://hub.docker.com/repositories "title") 


