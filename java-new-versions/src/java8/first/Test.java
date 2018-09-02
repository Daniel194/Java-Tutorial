package java8.first;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Test {

    public static void main(String... args) {
        User user = getTestUser();

        getUsersDto(Collections.singletonList(user))
                .forEach(System.out::println);
    }

    private static List<UserDto> getUsersDto(List<User> users) {
        return users
                .stream()
                .map(UserDto::new)
                .collect(toList());
    }

    private static User getTestUser() {
        User user = new User();
        user.setFirstName("Test 1");
        user.setLastName("Test 2");
        user.setUserName("Test 3");

        return user;
    }

}
