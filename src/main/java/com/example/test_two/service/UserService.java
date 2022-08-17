//package com.example.test_two.service;
//
//import com.example.test_two.entity.Role;
//import com.example.test_two.entity.User;
//import com.example.test_two.repository.RoleRepository;
//import com.example.test_two.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserService implements UserDetailsService {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    RoleRepository repository;
//
//    @Autowired
//    BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//
//        return user;
//    }
//
//    public User findUserById(Long userId) {
//        Optional<User> userFromDb = userRepository.findById(userId);
//
//        return userFromDb.orElse(new User());
//    }
//
//    public List<User> allUsers() {
//        return userRepository.findAll();
//    }
//
//    public boolean saveUser(User user) {
//        User userFromDb = userRepository.findByUsername(user.getUsername());
//        if (userFromDb != null)
//            return false;
//
//        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        userRepository.save(user);
//
//        return true;
//    }
//
//    public boolean deleteUser(Long userId) {
//        if (userRepository.findById(userId).isPresent()) {
//            userRepository.deleteById(userId);
//            return true;
//        }
//
//        return false;
//    }
//
//    public List<User> usergtList(Long idMin) {
//        return entityManager.createQuery("SELECT u FROM User u WHERE u.id > :paramId", User.class)
//                .setParameter("paramId",idMin).getResultList();
//    }
//}
