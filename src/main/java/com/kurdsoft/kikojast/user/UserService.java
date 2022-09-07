package com.kurdsoft.kikojast.user;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements IUserService{
    private final UserRep userRep;

    @Override
    public User save(User user) {
        return userRep.save(user);
    }

    @Override
    public User update(User user) {
        User lastUser=getById(user.getId());
        lastUser.setName(user.getName());
        lastUser.setLastName(user.getLastName());
        lastUser.setGmail(user.getGmail());
        lastUser.setPassWord(user.getPassWord());
        return userRep.save(lastUser);
    }

    @Override
    public void delete(Long id) {
        userRep.deleteById(id);

    }

    @Override
    public User getById(Long id) {
        Optional<User> optionalUser=userRep.findById(id);
        if(!optionalUser.isPresent()){
            throw new NotFoundException("Not Found");
        }
        return optionalUser.get();
    }

    @Override
    public List<User> getAll() {
        return (List<User>) userRep.findAll();
    }
}
