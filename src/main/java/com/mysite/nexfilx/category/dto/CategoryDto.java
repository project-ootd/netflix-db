package com.mysite.nexfilx.category.dto;

import com.mysite.nexfilx.category.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {
    private Long netflixContentsId;
    private String categoryType;

}
