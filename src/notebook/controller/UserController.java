package notebook.controller;

import notebook.model.User;
import notebook.model.repository.GBRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserController {
    private final GBRepository repository;
    private Optional<User> update;

    public UserController(GBRepository repository) {
        this.repository = repository;
    }

    public void saveUser(User user) {
        repository.create(user);
    }

    public User readUser(Long userId) throws Exception {
        List<User> users = repository.findAll();
        for (User user : users) {
            if (Objects.equals(user.getId(), userId)) {
                return user;
            }
        }

        throw new RuntimeException("User not found");
    }

    public void updateUser(String userId, User update) {
        update.setId(Long.parseLong(userId));
        this.update = repository.update(Long.parseLong(userId), update);
    }

    public List<User> readAll() {
        return repository.findAll();
    }
}
