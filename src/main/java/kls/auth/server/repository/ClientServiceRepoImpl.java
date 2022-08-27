package kls.auth.server.repository;

import kls.auth.server.model.sql.User;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ClientServiceRepoImpl implements UserServiceRepo {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final MapperRows mapperRows;

    @Override
    public User getFullClientInfoByUserName(@NonNull String username) {

        final String queryUser = "SELECT * FROM USER WHERE username = :username";
        final SqlParameterSource mapSqlParameterSource = new MapSqlParameterSource().addValue("username", username);

        return jdbcTemplate.queryForObject(queryUser, mapSqlParameterSource, mapperRows.getUserMapper());

    }
}
