package com.amindev.client;

import com.amindev.dto.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "BOOK-SERVICE")
public interface BookClient {
    @GetMapping("/book/{id}")
    Book getBookById(@PathVariable("id") Long id);
}

