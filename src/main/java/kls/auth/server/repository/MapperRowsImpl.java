package kls.auth.server.repository;

import kls.auth.server.model.sql.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
class MapperRowsImpl implements MapperRows {
    @Override
    public RowMapper<User> getUserMapper() {
        return (rs, rowNum) -> new User(rs.getString(1));
    }
}
