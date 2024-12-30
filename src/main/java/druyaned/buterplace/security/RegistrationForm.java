package druyaned.buterplace.security;

import druyaned.buterplace.ButerUser;
import druyaned.buterplace.validation.UsernameConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.security.crypto.password.PasswordEncoder;

public class RegistrationForm {
    
    @UsernameConstraint
    private String username;
    
    @Size(min = 4, message = "меньше 4 символов")
    private String password;
    
    @NotBlank(message = "пустое имя")
    private String name;
    
    @NotBlank(message = "пустой адрес")
    private String address;
    
    @Pattern(
            regexp = "\\+7 [0-9]{3} [0-9]{3} [0-9]{2} [0-9]{2}",
            message = "надо написать +7 XXX XXX XX XX, заменяя 'X' на цифры"
    )
    private String phoneNumber;
    
    public ButerUser toUser(PasswordEncoder encoder) {
        return new ButerUser(username, encoder.encode(password), name, address, phoneNumber);
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getName() {
        return name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
}
