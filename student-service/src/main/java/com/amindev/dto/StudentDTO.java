package com.amindev.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class StudentDTO {
    private Long studentID;
    @NotEmpty
    @NotNull
    @Size(min = 3, max = 25,message = "Username must be at least 3 char")
    private String username;
    private String role;
    private String password;
    private List<String> booksID = new ArrayList<>();
    private List<Book> books = new ArrayList<>();

}
