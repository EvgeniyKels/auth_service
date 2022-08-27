package kls.auth.server.model.config.sql;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@ConfigurationProperties(prefix = "jdbc-sql")
@Setter
public class JDBCConfigModel {
     private String driverClassName;
     private String url;
     private String userName;
     private String password;
}