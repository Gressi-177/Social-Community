package com.vietdoan.api.config;

import com.vietdoan.api.constants.HttpStatusCode;
import com.vietdoan.api.response.APIResponse;
import com.vietdoan.api.service.JwtService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    private  final UserDetailsService userDetailsService;
    private final  JwtService         jwtService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain)
            throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        String       jwt        = null;
        String       username   = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            jwt = authHeader.substring(7);
            try {
                username = jwtService.extractUsername(jwt);
            } catch (IllegalArgumentException e) {
                logger.error("---JWT Token:  unable to get");
            } catch (ExpiredJwtException e) {
                logger.error("---JWT Token:  expired");
            } catch (MalformedJwtException e) {
                logger.error("---JWT Token:  malformed");
            } catch (SignatureException e) {
                logger.error("---JWT Token:  signature does not match locally computed signature");
            }

            if(username==null){
                try{
                    ResponseEntity
                            .badRequest()
                            .body(
                                    APIResponse
                                    .builder()
                                    .status(HttpStatusCode.Unauthorized)
                                    .message("Unauthorized")
                                    .build());
                }catch (Exception e){

                }
            }
        } else {
            logger.error("---JWT Token: does not begin with Bearer String");
        }

        //Once we get the token validate it.
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

            if (jwtService.isTokenValid(jwt, userDetails)){
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );

                authenticationToken.setDetails(
                        new WebAuthenticationDetailsSource()
                                .buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        if(username!=null){
            request.setAttribute("userInfo", this.userDetailsService.loadUserByUsername(username));
        }

        filterChain.doFilter(request, response);
    }
}
