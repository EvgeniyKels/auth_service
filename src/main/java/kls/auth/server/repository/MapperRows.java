package kls.auth.server.repository;

import kls.auth.server.model.sql.User;
import org.springframework.jdbc.core.RowMapper;

interface MapperRows {
    default RowMapper<User> getUserMapper() {
        return (rs, rowNum) -> new User(rs.getString(1));
    }
}
