package com.github.druyaned.buters.props;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Data
@Component
@ConfigurationProperties(prefix = "buter.user")
@Validated
public class ButerUserProps {

    @Min(value = 1, message = "должно быть между 3 и 127")
    @Max(value = 127, message = "должно быть между 3 и 127")
    private int orderCountToShow = 15;

}
// TODO: orders of the current user PAGE (+ controller with adding to the model of orders)
// TODO: link in orderPickedUpPage
