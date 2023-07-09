package com.github.druyaned.buters.security;

import com.github.druyaned.buters.ButerUser;
import com.github.druyaned.buters.validation.UsernameConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@NoArgsConstructor
public class RegistrationForm {

    @UsernameConstraint
    private String username;
    
    @Size(min = 4, message = "меньше 4 символов")
    private String password;
    
    @NotBlank(message = "пустое имя")
    private String name;
    
    @NotBlank(message = "пустой адрес")
    private String address;
    
    @Pattern(regexp = "\\+7 [0-9]{3} [0-9]{3} [0-9]{2} [0-9]{2}",
            message = "надо написать +7 XXX XXX XX XX, заменяя 'X' на цифры")
    private String phoneNumber;
    
//-Methods------------------------------------------------------------------------------------------
    
    public ButerUser toUser(PasswordEncoder encoder) {
        return new ButerUser(username, encoder.encode(password), name, address, phoneNumber);
    }
    
}
