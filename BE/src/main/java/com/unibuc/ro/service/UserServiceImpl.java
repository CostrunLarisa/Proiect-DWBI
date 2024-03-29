package com.unibuc.ro.service;

import com.unibuc.ro.exception.InvalidUsernameException;
import com.unibuc.ro.exception.TokenValidationException;
import com.unibuc.ro.model.UserDetailsDTO;
import com.unibuc.ro.repository.UserRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final long TOKEN_VALABILITY = 86400000;
    private final SecretKey KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    public UserServiceImpl(UserRepository userRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("Loading by username: " + username);
        Optional<com.unibuc.ro.model.UserDetails> userDetails = userRepository.findByUsername(username);
        LOGGER.info(username);
        LOGGER.info(userDetails.get().getPassword());
        if (userDetails.isEmpty()) {
            throw new UsernameNotFoundException("User does not exist");
        }
        return userDetails.get();    }

    @Override
    public void save(UserDetailsDTO userDetails) {
        if (userDetails.getUsername().equals("")) {
            LOGGER.error("Empty username");
            throw new InvalidUsernameException("Choose a username");
        }
        Optional<com.unibuc.ro.model.UserDetails> user = userRepository.findByUsername(userDetails.getUsername());
        if (!user.isEmpty()) {
            LOGGER.error("This username already exists.");
            throw new InvalidUsernameException("This username already exists, please choose a different one.");
        }
        LOGGER.info("Username " + userDetails.getUsername() + " saved.");
        LOGGER.info("Password " + userDetails.getPassword() + " saved.");
        LOGGER.info("Password " + bCryptPasswordEncoder.encode(userDetails.getPassword()) + " saved.");

        userRepository.save(com.unibuc.ro.model.UserDetails.builder()
                .email(userDetails.getEmail())
                .firstName(userDetails.getFirstName())
                .lastName(userDetails.getLastName())
                .username(userDetails.getUsername())
                .password(bCryptPasswordEncoder.encode(userDetails.getPassword()))
                .build());
    }

    @Override
    public String generateToken(String username) {
        Date now = new Date();
        Date expireDate = new Date(now.getTime() + TOKEN_VALABILITY);
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expireDate)
                .signWith(KEY)
                .compact();
    }
    @Override
    public String decryptToken(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(KEY)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return claims.getSubject();
        } catch (Exception e) {
            throw new TokenValidationException("Authentication token is invalid.");
        }
    }
}
