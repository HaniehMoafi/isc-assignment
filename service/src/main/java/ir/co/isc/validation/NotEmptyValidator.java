package ir.co.isc.validation;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class NotEmptyValidator implements ConstraintValidator<NotEmpty, Object> {


    @Override
    public void initialize(NotEmpty constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        return !checkIsNull(obj);
    }

    private boolean checkIsNull(Object obj) {
        if (Objects.isNull(obj))
            return true;
        else if (obj instanceof String) {
            return !StringUtils.hasText(obj.toString());
        } else return false;
    }
}
