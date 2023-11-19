package com.asm01.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.asm01.entity.User;

@Component
public class UserDao {
	private List<User> userdao =  new ArrayList<>();
	
    public Optional<User> get(int id) {
        return Optional.ofNullable(userdao.get(id));
    }
    
    public Collection<User> getAll() {
        return userdao.stream()
          .filter(Objects::nonNull)
          .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }
    
    public int save(User users) {
        userdao.add(users);
        int index = userdao.size() - 1;
        users.setId(index);
        return index;
    }
    
    public void update(User user) {
        userdao.set(user.getId(), user);
    }
    
    public void delete(User user) {
        userdao.set(user.getId(), null);
    }
}
