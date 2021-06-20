package sample._02_pattern._01_valueObject._08;

import java.util.Objects;

public class UserService {
    public User create(String name){
        Objects.requireNonNull(name);
        if (name.length() < 3) {
            throw new IllegalArgumentException("ユーザ名は3文字移譲です。");
        }

        var user = new User(name);

        return user;
    }

    public void update(String id, String name) {
        Objects.requireNonNull(name);
        if (name.length() < 3) {
            throw new IllegalArgumentException("ユーザ名は3文字移譲です。");
        }

        // Updateなので本来は id で更新対象を検索して更新する
        var user = new User(id, name);
    }
}
