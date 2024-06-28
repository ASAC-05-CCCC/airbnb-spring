package com.Cccccc.airbnb.domain.room.service;

import com.Cccccc.airbnb.domain.room.dto.CategoryDto;
import com.Cccccc.airbnb.domain.room.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(category -> new CategoryDto(category.getCategory_name(), category.getImage()))
                .collect(Collectors.toList());
    }
}
