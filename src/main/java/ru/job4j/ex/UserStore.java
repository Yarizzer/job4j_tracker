package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User res = null;
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                res = user;
            }
        }
        if (res != null) {
            return res;
        } else {
            throw new UserNotFoundException("User not found");
        }
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.isValid() && user.getUsername().length() > 2) {
            return true;
        } else {
            throw new UserInvalidException("User data not valid");
        }
    }

    public static void main(String[] args) {
        User[] data = {
                new User("John Smith", true)
        };
        try {
            validate(findUser(data, "John Smith"));
        } catch (UserInvalidException ve) {
            ve.printStackTrace();
        } catch (UserNotFoundException nfe) {
            nfe.printStackTrace();
        }
    }
}
