package sn.ridwan.ipm.service;

import sn.ridwan.ipm.model.User;

import java.util.List;

public interface UserIservice {
    public void login(String username, String password);
    public User findUser(String username, String password);
    public User createUser(String numipm, String numphone,String email,String password);
    public boolean removeUser(Long id);
    public List<User> getAllUser();
}
