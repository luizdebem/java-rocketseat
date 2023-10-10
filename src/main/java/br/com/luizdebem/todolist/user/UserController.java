package br.com.luizdebem.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
  // autowired gerencia o ciclo de vida da instância nesse caso do userRepository
  @Autowired
  private IUserRepository userRepository;

  @PostMapping("/")
  public ResponseEntity<?> create(@RequestBody UserModel userModel) {
    UserModel user = this.userRepository.findByUsername(userModel.getUsername());

    if (user != null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists.");
    }

    UserModel createdUser = this.userRepository.save(userModel);
    return ResponseEntity.status(HttpStatus.OK).body(createdUser);
  }
}
