package com.github.druyaned.buters.web;

import com.github.druyaned.buters.ButerUser;
import com.github.druyaned.buters.Ingredient;
import com.github.druyaned.buters.data.IngredientRepository;
import com.github.druyaned.buters.data.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("homePage");
        registry.addViewController("/login").setViewName("loginForm");
        registry.addViewController("/logout").setViewName("logoutForm");
        registry.addViewController("/orders/pickedup").setViewName("orderPickedUpPage");
    }
    
    @Bean
    @Profile("dev-h2")
    public CommandLineRunner dataLoader(IngredientRepository ingrRepo,
            UserRepository userRepo, PasswordEncoder encoder) {
        return args -> {
            ingrRepo.save(new Ingredient("WHBR", "Белый Хлебушек", Ingredient.Type.WRAP));
            ingrRepo.save(new Ingredient("BLBR", "Черный Хлебушек", Ingredient.Type.WRAP));
            ingrRepo.save(new Ingredient("LVSH", "Лавашик", Ingredient.Type.WRAP));
            ingrRepo.save(new Ingredient("BEEF", "Говядинка", Ingredient.Type.PROTEIN));
            ingrRepo.save(new Ingredient("CHKN", "Курятинка", Ingredient.Type.PROTEIN));
            ingrRepo.save(new Ingredient("TRKY", "Индюшатинка", Ingredient.Type.PROTEIN));
            ingrRepo.save(new Ingredient("CMBR", "Огурчик", Ingredient.Type.VEGGIE));
            ingrRepo.save(new Ingredient("TMTO", "Помидорчик", Ingredient.Type.VEGGIE));
            ingrRepo.save(new Ingredient("SLGN", "Сулугуни", Ingredient.Type.CHEESE));
            ingrRepo.save(new Ingredient("DTCH", "Голландский", Ingredient.Type.CHEESE));
            ingrRepo.save(new Ingredient("PSTO", "Песто", Ingredient.Type.SAUCE));
            ingrRepo.save(new Ingredient("GRLC", "Чесночный", Ingredient.Type.SAUCE));
            ButerUser user = new ButerUser("ed", encoder.encode("pass"), "Эд",
                    "ул. Вязов, д. 10, кв. 5", "+7 980 123 45 67");
            userRepo.save(user);
        };
    }

}
