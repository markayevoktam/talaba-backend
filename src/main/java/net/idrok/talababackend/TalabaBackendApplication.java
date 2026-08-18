package net.idrok.talababackend;

import net.idrok.talababackend.entity.Role;
import net.idrok.talababackend.entity.User;
import net.idrok.talababackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@SpringBootApplication
public class TalabaBackendApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(TalabaBackendApplication.class, args);
	}

	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Optional<User> uk = userRepository.findByLogin("admin123");
		if(!uk.isPresent()){
			User u = new User();
			u.setIsm("admin");
			u.setFamiliya("Admin");
			u.setLogin("admin123");
			u.setParol(passwordEncoder.encode("admin123"));
			u.setAktiv(true);
			u.setRole(Role.ADMIN);

			userRepository.save(u);
		} else if (uk.get().getRole() != Role.ADMIN) {
			// Rol ustuni keyin qo'shilgan: mavjud boshlang'ich admin'ga rol beriladi
			User u = uk.get();
			u.setRole(Role.ADMIN);
			userRepository.save(u);
		}
	}
}
