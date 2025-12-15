package org.example.bephim.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.bephim.repository.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private UserRepository userRepository;

    public JwtAuthenticationFilter(JwtService jwtService,UserRepository userRepository) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    @Override

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        final String jwt = authHeader.substring(7);
        final String userName = jwtService.extractUsername(jwt);
        if (userName != null&& SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails=userRepository.findByUsername(userName).orElse(null);

            if (userDetails != null && jwtService.isTokenValid(jwt, userDetails)) {
                // Tạo token xác thực
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());

                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // 🔐 Gắn vào SecurityContext
                SecurityContextHolder.getContext().setAuthentication(authToken);
                System.out.println("==> Xác thực hiện tại: " + SecurityContextHolder.getContext().getAuthentication());


            }

        }
        filterChain.doFilter(request, response);
    }
}
