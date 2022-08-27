package kls.auth.server.configuration;

import kls.auth.server.model.config.sql.JDBCConfigModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("kls.auth.server.model.config.sql")
public class JdbcConfig {

    private final JDBCConfigModel jdbcConfigModel;

    @Autowired
    public JdbcConfig(JDBCConfigModel jdbcConfigModel) {
        this.jdbcConfigModel = jdbcConfigModel;
    }

    @Bean
    public DataSource mySqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(jdbcConfigModel.getDriverClassName());
        dataSource.setUrl(jdbcConfigModel.getUrl());
        dataSource.setUsername(jdbcConfigModel.getUserName());
        dataSource.setPassword(jdbcConfigModel.getPassword());
        return dataSource;
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate () {
        return new NamedParameterJdbcTemplate(mySqlDataSource());
    }

}
