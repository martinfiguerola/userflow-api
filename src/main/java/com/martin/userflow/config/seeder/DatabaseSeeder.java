package com.martin.userflow.config.seeder;

import com.github.javafaker.Faker;
import com.martin.userflow.entity.User;
import com.martin.userflow.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Profile("dev") // This component only runs when the 'dev' profile is active
public class DatabaseSeeder implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseSeeder.class);
    private final UserRepository repository;
    private static final Faker faker = new Faker();

    public DatabaseSeeder(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Only insert fake users if the database is empty
        if (repository.count() == 0 ) {

            // Initialize a list to hold the generated users
            List<User> users = new ArrayList<>();

            // Generate 30 fake users using a loop and Faker
            for (int i = 0; i < 30; i++ ){

                // Create sample users for development environment
                User user = new User();
                user.setName(faker.name().fullName());
                user.setEmail(faker.internet().emailAddress());
                user.setPassword(faker.internet().password());

                // Add the user created to the list
                users.add(user);
            }

            // Save all generated users to the database
            repository.saveAll(users);

            // Log created users to confirm seeding worked
            logger.info("Seeded {} users.", users.size());

        }


    }
}
