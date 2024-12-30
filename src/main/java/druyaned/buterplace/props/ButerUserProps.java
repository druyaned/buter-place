package druyaned.buterplace.props;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@ConfigurationProperties(prefix="buter.user")
@Validated
public class ButerUserProps {
    
    @Min(value = 1, message = "должно быть между 3 и 127")
    @Max(value = 127, message = "должно быть между 3 и 127")
    private int orderCountToShow = 15;
    
    public int getOrderCountToShow() {
        return orderCountToShow;
    }
    
    public void setOrderCountToShow(int orderCountToShow) {
        this.orderCountToShow = orderCountToShow;
    }
    
    @Override public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.orderCountToShow;
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
        final ButerUserProps other = (ButerUserProps)obj;
        return this.orderCountToShow == other.orderCountToShow;
    }
    
    @Override public String toString() {
        return "ButerUserProps{orderCountToShow=" + orderCountToShow + '}';
    }
    
}
// TODO: orders of the current user PAGE (+ controller with adding to the model of orders)
// TODO: link in orderPickedUpPage
