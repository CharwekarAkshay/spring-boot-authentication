package com.mycompany.domain;

public class AuthenticationResponseDTO {
    private final String jwt;

    /**
     * 
     * Authentication Response Object creation
     * 
     * @param jwt
     */
    public AuthenticationResponseDTO(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

}
