package druyaned.buterplace;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDateTime;
import druyaned.buterplace.validation.CardExpirationConstraint;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

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
        
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber.replace(" ", ""); // removing all spaces
    }
    
    public boolean addButer(Buter buter) {
        return buters.add(buter);
    }
    
    public Long getId() {
        return id;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getRecipient() {
        return recipient;
    }
    
    public String getDeliveryAddress() {
        return deliveryAddress;
    }
    
    public String getCardNumber() {
        return cardNumber;
    }
    
    public String getCardExpiration() {
        return cardExpiration;
    }
    
    public String getCardCVV() {
        return cardCVV;
    }
    
    public List<Buter> getButers() {
        return buters;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
    
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
    
    public void setCardExpiration(String cardExpiration) {
        this.cardExpiration = cardExpiration;
    }
    
    public void setCardCVV(String cardCVV) {
        this.cardCVV = cardCVV;
    }
    
    public void setButers(List<Buter> buters) {
        this.buters = buters;
    }
    
    @Override public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
        hash = 11 * hash + Objects.hashCode(this.createdAt);
        hash = 11 * hash + Objects.hashCode(this.username);
        hash = 11 * hash + Objects.hashCode(this.recipient);
        hash = 11 * hash + Objects.hashCode(this.deliveryAddress);
        hash = 11 * hash + Objects.hashCode(this.cardNumber);
        hash = 11 * hash + Objects.hashCode(this.cardExpiration);
        hash = 11 * hash + Objects.hashCode(this.cardCVV);
        hash = 11 * hash + Objects.hashCode(this.buters);
        return hash;
    }
    
    @Override public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ButerOrder other = (ButerOrder) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.recipient, other.recipient)) {
            return false;
        }
        if (!Objects.equals(this.deliveryAddress, other.deliveryAddress)) {
            return false;
        }
        if (!Objects.equals(this.cardNumber, other.cardNumber)) {
            return false;
        }
        if (!Objects.equals(this.cardExpiration, other.cardExpiration)) {
            return false;
        }
        if (!Objects.equals(this.cardCVV, other.cardCVV)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.createdAt, other.createdAt)) {
            return false;
        }
        return Objects.equals(this.buters, other.buters);
    }
    
    @Override public String toString() {
        return "ButerOrder{id=" + id
                + ", createdAt=" + createdAt
                + ", username=" + username
                + ", recipient=" + recipient
                + ", deliveryAddress=" + deliveryAddress
                + ", cardNumber=" + cardNumber
                + ", cardExpiration=" + cardExpiration
                + ", cardCVV=" + cardCVV
                + ", buters=" + buters
                + '}';
    }
    
}
