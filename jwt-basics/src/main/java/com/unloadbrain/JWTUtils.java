package com.unloadbrain;


import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.KeyLengthException;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import java.text.ParseException;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

public class JWTUtils {

    // DO NOT USE IN PRODUCTION, ALWAYS READ FROM PROPERTIES FILE
    private static final String SIGNING_SECRET = "secret0123456789secret0123456789";
    private static MACSigner macSigner;
    private static MACVerifier macVerifier;

    static {

        try {
            macSigner = new MACSigner(SIGNING_SECRET);
        } catch (KeyLengthException e) {
            throw new RuntimeException(e);
        }

        try {
            macVerifier = new MACVerifier(SIGNING_SECRET);
        } catch (JOSEException e) {
            e.printStackTrace();
        }

    }

    public String createJwtToken(Map<String, String> data) {

        JWSHeader header = new JWSHeader.Builder(JWSAlgorithm.HS256)
                .type(JOSEObjectType.JWT)
                .build();

        JWTClaimsSet.Builder builder = new JWTClaimsSet.Builder()
                .expirationTime(Date.from(Instant.now().plusSeconds(120)));
        data.entrySet().stream().forEach(entry -> builder.claim(entry.getKey(), entry.getValue()));
        JWTClaimsSet claimsSet = builder.build();

        SignedJWT signedJWT = new SignedJWT(header, claimsSet);
        try {
            signedJWT.sign(macSigner);
        } catch (JOSEException e) {
            throw new RuntimeException(e);
        }


        return signedJWT.serialize();
    }

    public boolean isValidJwtToken(String token) {

        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            return signedJWT.verify(macVerifier);
        } catch (ParseException | JOSEException e) {
            throw new RuntimeException(e);
        }
    }
}
