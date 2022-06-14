# Petrol Single Page Web Application
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
| Component                               | Function                                                                                           | Port   |
|-----------------------------------------|----------------------------------------------------------------------------------------------------|--------|
| ``AngularWebApp (angular-auth-oidc-client)`` | Provides signup, login to OpenID Spring authorization server to secured content                    | 8081   |
| ``Client-Gateway``                      | Spring cloud gateway based - routes, load balancers, security (authorization)                      | 8082   |
| ``Cloud-Discovery``                     | Spring Cloud Netflix based - service discovery                                                     | 8761   |
| ``User Manager Resource``               | Spring boot auhtorization server openID connect based authentication and authorization to manager users | 8084   |
| ``Business Resource``                   | Spring boot web with security and serve security content                                           | 8085   |

### Architecture
- ``AngularWebApp (angular-auth-oidc-client) --> Client-gateway--> Authentication (User Manager Resource)``
- ``AngularWebApp --> Client-Gateway--> Authorization (User Manager Resource)``
- ``AngularWebApp --> Client-Gateway--> Cloud-Discovery --> ResourceServer with Bearer token Jwt (User Manager Resource)``



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


