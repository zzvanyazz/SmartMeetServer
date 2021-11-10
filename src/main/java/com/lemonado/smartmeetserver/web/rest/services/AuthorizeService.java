package com.lemonado.smartmeetserver.web.rest.services;

import com.lemonado.smartmeetserver.core.data.exceptions.LoginFailedException;
import com.lemonado.smartmeetserver.core.services.users.UserService;
import com.lemonado.smartmeetserver.web.rest.models.auth.InvalidTokenException;
import com.lemonado.smartmeetserver.web.rest.models.auth.TokenBlockedException;
import com.lemonado.smartmeetserver.web.rest.models.requests.auth.AuthRequest;
import com.lemonado.smartmeetserver.web.rest.models.requests.auth.RefreshTokenRequest;
import com.lemonado.smartmeetserver.web.rest.models.responses.AuthResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.AuthenticationFailedException;


@Service
public class AuthorizeService {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;


    public AuthResponseData authenticate(AuthRequest request)
            throws LoginFailedException {
        var user = userService.login(request.username(), request.password());

        return tokenService.createAuthData(user);
    }

    public AuthResponseData refreshToken(RefreshTokenRequest request)
            throws InvalidTokenException, AuthenticationFailedException, TokenBlockedException {
        var token = tokenService.parseRefreshToken(request.token());
        var user = userService.findActiveUser(token.userId());

        if (tokenService.isTokenBlocked(user, token)) {
            throw new TokenBlockedException();
        }

        return tokenService.createAuthData(user);
    }

}



