package com.soltrix.service;

import com.soltrix.dto.CartItemRequest;
import com.soltrix.entity.Cart;

public interface CartService {
    Cart getCartByUserId(Long userId);
    Cart addItemToCart(Long userId, CartItemRequest itemRequest);
    Cart updateItemQuantity(Long userId, Long cartItemId, Integer quantity);
    Cart removeItemFromCart(Long userId, Long cartItemId);
    void clearCart(Long userId);
}
