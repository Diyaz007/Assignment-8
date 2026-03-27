package mystartup.assignment8.dto;

import java.math.BigDecimal;

public record UpdateEmployer (
        String name,
        String position,
        BigDecimal salary,
        String hireDate){

}