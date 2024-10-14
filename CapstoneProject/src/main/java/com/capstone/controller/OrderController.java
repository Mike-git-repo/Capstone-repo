package com.capstone.controller;

import com.capstone.service.OrderService;
import com.capstone.utils.Result;
import jakarta.persistence.OptimisticLockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // 乐观锁购买商品并生成订单
    @PostMapping("/optimistic")
    public Result<?> purchaseWithOptimistic(@RequestParam Long userId, @RequestParam Long productId, @RequestParam int quantity) {
        try {
            String result = orderService.purchaseProductWithOptimisticLock(userId, productId, quantity);
            return Result.success(result);
        } catch (OptimisticLockException e) {
            return Result.error("Transaction conflict, please retry.");
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    // 悲观锁购买商品并生成订单
    @PostMapping("/pessimistic")
    public Result<?> purchaseWithPessimistic(@RequestParam Long userId, @RequestParam Long productId, @RequestParam int quantity) {
        try {
            String result = orderService.purchaseProductWithPessimisticLock(userId, productId, quantity);
            return Result.success(result);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

}
