package org.example.elastictest.init;

import lombok.RequiredArgsConstructor;
import org.example.elastictest.document.UserDocument;
import org.example.elastictest.document.repository.UserSearchRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitRunner implements CommandLineRunner {
    private final UserSearchRepository userSearchRepository;

    @Override
    public void run(String... args) {
        userSearchRepository.save(new UserDocument("1", "hayan", "Hello my name is hayan"));
        userSearchRepository.save(new UserDocument("2", "hailey", "I'm so happy"));
        userSearchRepository.save(new UserDocument("3", "hajin", "I'm so Sad about that"));
    }
}
