package com.boost.SocialCocktailJavaServer;

import com.boost.SocialCocktailJavaServer.models.Bartender;
import com.boost.SocialCocktailJavaServer.models.User;
import com.boost.SocialCocktailJavaServer.repositories.BartenderRepository;
import com.boost.SocialCocktailJavaServer.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private BartenderRepository bartenderRepository;

    @Autowired
    public DataLoader(BartenderRepository bartenderRepository) {
        this.bartenderRepository = bartenderRepository;
    }

    public void run(ApplicationArguments args) {
        if (bartenderRepository.findByUsername("admin") == null) {
            Bartender adminAccount = new Bartender();
            adminAccount.setUsername("admin");
            adminAccount.setPassword("240be518fabd2724ddb6f04eeb1da5967448d7e831c08c8fa822809f74c720a9");
            adminAccount.setVerified(true);
            adminAccount.setAdmin(true);
            adminAccount.setId(0);
            bartenderRepository.save(adminAccount);
        }
    }
}