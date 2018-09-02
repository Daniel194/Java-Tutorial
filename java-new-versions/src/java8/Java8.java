package java8;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Java8 {

    public static void main(String... args) {

    }

    public List<UserDto> getAllUsers(List<User> users) {
        return users
                .stream()
                .map(UserDto::new)
                .collect(toList());
    }

}
