package kls.auth.server.repository;

import kls.auth.server.model.sql.User;
import lombok.NonNull;

public interface UserServiceRepo {

    User getFullClientInfoByUserName(@NonNull String username);

}
