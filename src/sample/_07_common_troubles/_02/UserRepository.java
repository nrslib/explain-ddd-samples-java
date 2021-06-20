package sample._07_common_troubles._02;

import java.util.ArrayList;
import java.util.Optional;

public interface UserRepository {
    void save(User user);
    Optional<User> find(UserId id);
    ArrayList<User> find(ArrayList<UserId> ids);
}
