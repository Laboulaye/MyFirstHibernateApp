package services;

import dao.UserDao;
import models.Auto;
import models.User;

import java.util.List;

//Слой данных в приложении, отвечающий за выполнение бизнес-логики
//Сервис одержит внутри себя userDao и в своих методах вызывает методы Dao
public class UserService {

    private UserDao userDao = new UserDao();

    public UserService() {}


    public User findUser(int id) {
        return userDao.findById(id);
    }

    public void saveUser(User user) {
        userDao.save(user);
    }

    public void deleteUser(User user) {
        userDao.delete(user);
    }

    public void updateUser(User user) {
        userDao.update(user);
    }
    public List<User> dinfAllUsers() {
        return userDao.findAll();
    }

    public Auto findAutoById(int id) {
        return userDao.findAutoById(id);
    }


}
