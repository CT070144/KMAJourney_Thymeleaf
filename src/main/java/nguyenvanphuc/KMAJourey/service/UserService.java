package nguyenvanphuc.KMAJourey.service;

import lombok.extern.slf4j.Slf4j;
import nguyenvanphuc.KMAJourey.entity.User;
import nguyenvanphuc.KMAJourey.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
   public User createUser(String username, String password){
       password = passwordEncoder.encode(password);
       log.info(password);
       User user = User.builder()
               .username(username)
               .password(password)
               .build();
       return  userRepository.save(user);
   }
    public boolean getUser(String username, String password){
        User user = userRepository.findByusername(username);


        if(user != null && passwordEncoder.matches(password,user.getPassword())){
            return true;
        }
        return false;
    }
    public boolean checkUser(String username){
       return ((userRepository.findByusername(username)!=null)?true:false);
    }

}
