package com.github.druyaned.buters;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDateTime;
import lombok.Data;
import com.github.druyaned.buters.validation.CardExpirationConstraint;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@Table
public class ButerOrder implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id private Long id;
    
    private LocalDateTime createdAt = LocalDateTime.now();
    
    private String username;
    
    @NotBlank(message = "пустое имя получателя")
    private String recipient;
    
    @NotBlank(message = "пустой адрес доставки")
    private String deliveryAddress;
    
    @Pattern(regexp = "[0-9]{16}", message = "требуются 16 цифр и допускаются пробелы")
    private String cardNumber;
    
    @CardExpirationConstraint
    private String cardExpiration;
    
    @Digits(integer = 3, fraction = 0, message = "требуются только 3 цифры")
    private String cardCVV;
    
    @Size(min = 1, message = "требуется хотя бы 1 бутер")
    private List<Buter> buters = new ArrayList<>();
    
//-Methods------------------------------------------------------------------------------------------
    
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber.replace(" ", ""); // removing all spaces
    }
    
    public boolean addButer(Buter buter) {
        return buters.add(buter);
    }
    
    // TODO: implement removeButer

}
