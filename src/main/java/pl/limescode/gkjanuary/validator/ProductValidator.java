package pl.limescode.gkjanuary.validator;

import org.springframework.stereotype.Component;
import pl.limescode.gkjanuary.dto.ProductCreateDto;
import pl.limescode.gkjanuary.dto.ProductDto;
import pl.limescode.gkjanuary.exception.ValidationException;

@Component
public class ProductValidator {

    public void validate(ProductDto dto) {
        if (dto == null) {
            throw new ValidationException("Product can't not be null");
        }
        if (dto.getId() == null) {
            throw new ValidationException("Product id can not be empty");
        }
        if (dto.getPrice() < 0) {
            throw new ValidationException("Price can not be lower than 0");
        }
        if (dto.getName().isBlank()) {
            throw new ValidationException("Name of the product can't be blank");
        }
    }

    public void validate(ProductCreateDto dto) {
        if (dto.getPrice() < 0) {
            throw new ValidationException("Price can not be lower than 0");
        }
        if (dto.getName().isBlank()) {
            throw new ValidationException("Name of the product can't be blank");
        }
    }
}
