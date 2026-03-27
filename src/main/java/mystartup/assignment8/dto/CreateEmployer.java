package mystartup.assignment8.dto;

import java.math.BigDecimal;

public record CreateEmployer (
    String name,
    String position,
    BigDecimal salary,
    String hireDate){

}
