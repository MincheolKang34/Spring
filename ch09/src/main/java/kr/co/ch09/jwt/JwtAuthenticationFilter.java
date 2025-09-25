package kr.co.ch09.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtProvider jwtProvider;

    private final String AUTH_HEADER = "Authorization";
    private final String TOKEN_PREFIX = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 토큰 추출
        String  header = request.getHeader(AUTH_HEADER);
        log.info("header : {}", header);

        if (header == null) {
            log.info("header is null");
            filterChain.doFilter(request, response);
            return;
        }

        // 토큰 검사

        filterChain.doFilter(request, response);
    }
}
