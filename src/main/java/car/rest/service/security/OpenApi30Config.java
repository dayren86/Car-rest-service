package car.rest.service.security;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Fox Cars", version = "v1"))
//@SecurityScheme(name = "openid",
//        type = SecuritySchemeType.OPENIDCONNECT,
//        openIdConnectUrl = "http://localhost:8080/realms/car/.well-known/openid-configuration"
//        )
public class OpenApi30Config {
}
