package com.switchfully.javadocjuveniles.api.security.authentication.external;

import org.springframework.stereotype.Service;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class FakeAuthenticationService {

    private List<ExternalAuthentication> externalAuthentications = newArrayList(
            ExternalAuthentication.externalAuthentication().withUsername("aMember").withPassword("aPassword").withRoles(newArrayList("MEMBER")),
            ExternalAuthentication.externalAuthentication().withUsername("aLibrarian").withPassword("aPassword").withRoles(newArrayList("LIBRARIAN")),
            ExternalAuthentication.externalAuthentication().withUsername("aAdmin").withPassword("aPassword").withRoles(newArrayList("ADMIN"))
    );

    public ExternalAuthentication getUser(String username, String password) {
        return externalAuthentications.stream()
                .filter(externalAuthentication -> externalAuthentication.getUsername().equals(username))
                .filter(externalAuthentication -> externalAuthentication.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }
}
