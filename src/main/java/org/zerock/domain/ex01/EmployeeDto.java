package org.zerock.domain.ex01;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EmployeeDto {
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private String photo;
	private String notes;
}
