package net.idrok.talababackend.service;

import net.idrok.talababackend.entity.User;
import net.idrok.talababackend.repository.UserRepository;
import net.idrok.talababackend.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;


    public List<User> getAll(String key) {
        // TODO Auto-generated method stub
        return userRepository.findAll();
    }


    public User getById(Long id) {
        // TODO Auto-generated method stub
        return userRepository.findById(id).get();
    }


    public User create(User entity) {
        // TODO Auto-generated method stub
        if(entity.getId() == null){
            entity.setRegVaqt(LocalDateTime.now());
            entity.setOxirgiTashrif(LocalDateTime.now());
            entity.setAktiv(true);
            entity.setParol(encoder.encode(entity.getParol()));
            return userRepository.save(entity);
        }
        throw new RuntimeException("id null bo'lsihi shart");
    }


    public User update(User entity) {
        // TODO Auto-generated method stub
        return userRepository.save(entity);
    }


    public void delete(User entity) {
        // TODO Auto-generated method stub
        userRepository.delete(entity);

    }


    public void deleteById(Long dataId) {
        // TODO Auto-generated method stub
        userRepository.deleteById(dataId);

    }


    public Optional<User> getByLogin(String login) {
        return userRepository.findByLogin(login);
    }


    public UserDTO getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth.getPrincipal() instanceof UserDetails){
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            User u = userRepository.findByLogin(userDetails.getUsername()).orElseThrow(()->  new RuntimeException("not found"));
            return new UserDTO(u);
        }
        throw new RuntimeException("not found");
    }

}
