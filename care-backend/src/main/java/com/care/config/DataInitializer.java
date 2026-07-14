package com.care.config;

import com.care.role.Role;
import com.care.role.RoleRepository;
import com.care.role.RoleType;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) {

        if (roleRepository.count() > 0) {
            return;
        }

        roleRepository.save(
                Role.builder()
                        .name(RoleType.ADMIN)
                        .build()
        );

        roleRepository.save(
                Role.builder()
                        .name(RoleType.INVESTIGATOR)
                        .build()
        );

        roleRepository.save(
                Role.builder()
                        .name(RoleType.ANALYST)
                        .build()
        );

        System.out.println("Default roles initialized successfully.");

    }
}