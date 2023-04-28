package com.example.demo.controllers;

import com.example.demo.jsonmodels.GenericEntityJsonModel;
import com.example.demo.services.SaveRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.time.Instant;
import java.util.stream.Collectors;

@RestController
public class MainController {
    @Autowired
    JwtEncoder encoder;

    @Autowired
    SaveRecordService saveRecordService;

    @PostMapping("/token")
    public String token(Authentication authentication) {
        Instant now = Instant.now();
        long expiry = 36000L;
        String scope = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry))
                .subject(authentication.getName())
                .claim("scope", scope)
                .build();
        return this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    @GetMapping("/nocontent")
    @PostMapping("/nocontent")
    public ResponseEntity<Object> noContent(Authentication authentication) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/echo")
    public ResponseEntity<GenericEntityJsonModel> echo(Authentication authentication, @RequestBody GenericEntityJsonModel genericEntity) throws URISyntaxException {
        saveRecordService.writeGenericEntityToDb(genericEntity);
        return ResponseEntity.status(HttpStatus.OK).body(genericEntity);
    }

    @PostMapping("/device")
    public ResponseEntity<String> device(Authentication authentication, @RequestBody GenericEntityJsonModel genericEntity) throws URISyntaxException {
        saveRecordService.writeGenericEntityToDb(genericEntity);
        return ResponseEntity.status(HttpStatus.OK).body(genericEntity.getDeviceId());
    }
}
