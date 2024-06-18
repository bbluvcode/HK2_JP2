/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author User
 */
public class UserDAO implements IDAO<User> {

    public ArrayList<User> users = new ArrayList();

    public UserDAO() {

    }

    @Override
    public void create(User t) {
        users.add(t);
    }

    @Override
    public Optional<User> read(String id) {
        for (User u : users) {
            if (u.getId().equals(id)) {
                return Optional.of(u);
            }
        }
        return Optional.empty();
    }
    @Override
    public void update(User t) {
        for (User u : users) {
            if (u.getId().equals(t.getId())) {
                u.setName(t.getName());
                u.setEmail(t.getEmail());
            }
        }
    }

    @Override
    public void delete(User t) {
        users.removeIf(u -> u.getId().equals(t.getId()));
    }

    @Override
    public List<User> getAll() {
        return users;
    }

}
