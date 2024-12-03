package use_case.add_to_fav;

import entity.User;

class MockAddToFavDataAccess implements AddToFavDataAccessInterface {
    private boolean userExists = true; // Default user existence
    private User mockUser = new User("testUser", "testPassword"); // Adjusted constructor

    @Override
    public User get(String username) {
        return userExists && "testUser".equals(username) ? mockUser : null;
    }

    @Override
    public String getCurrentUsername() {
        return userExists ? "testUser" : null;
    }

    @Override
    public void save(User user) {
        if (user == null) {
            throw new RuntimeException("User cannot be null");
        }
        // Simulate save behavior
    }

    // Custom setter for test flexibility
    public void setUserExists(boolean userExists) {
        this.userExists = userExists;
    }
}
