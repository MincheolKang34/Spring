package kr.co.ch09.controller;

import kr.co.ch09.dto.CartDTO;
import kr.co.ch09.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CartController {
    final CartService cartService;

    @PostMapping("/cart")
    public ResponseEntity<CartDTO> addCart(@RequestBody CartDTO cartDTO) {
        log.info("cartDTO : {}", cartDTO);

        CartDTO savedCart = cartService.save(cartDTO);

        return ResponseEntity.ok(savedCart);
    }

    @GetMapping("/cart")
    public ResponseEntity<List<CartDTO>> getCartList(@RequestBody String userid) {
        List<CartDTO> dtoList = cartService.findByUserid(userid);

        return ResponseEntity.ok(dtoList);
    }
}
