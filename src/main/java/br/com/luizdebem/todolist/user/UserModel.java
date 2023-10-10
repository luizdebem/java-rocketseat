package br.com.luizdebem.todolist.user;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
// Lombok: lib que facilita os getters e setters, não precisa nem especificar.
import lombok.Data;
import lombok.Getter;

@Data
@Entity(name="tb_users")
public class UserModel {
  @Getter
  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;
  @Column(unique = true)
  private String username;
  private String fullname;
  private String password;
  @CreationTimestamp
  private LocalDateTime createdAt;
  @UpdateTimestamp
  private LocalDateTime updatedAt;
}
