package java8;

public class UserDto {
    private String userName;
    private String fullName;
    private boolean active;

    public UserDto(User user) {
        userName = user.getUserName();
        fullName = user.getFirstName() + " " + user.getLastName().toUpperCase();
        active = user.getDeactivationDate() == null;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
