package org.zerock.mapper.ex02;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.zerock.domain.ex01.CustomerDto;
import org.zerock.domain.ex01.EmployeeDto;

public interface Ex02Mapper {

	@Select("SELECT CustomerName FROM Customers WHERE CustomerId = #{id}")
	String selectNameById(int id);

	@Select("SELECT FirstName FROM Employees WHERE EmployeeID = #{id}")
	String selectFirstNameById(int id);

	@Select("SELECT CustomerName Name, Address, City, Country FROM Customers WHERE CustomerId = #{id}")
	CustomerDto selectCustomerById(int id);
	
	@Select("SELECT FirstName, LastName, BirthDate FROM Employees WHERE EmployeeId = #{id}")
	EmployeeDto selectEmployeeByID(int id);

	@Insert("INSERT INTO Customers "
			+ " (CustomerName, ContactName, City, Country, Address, PostalCode) "
			+ "VALUES (#{customerName}, #{contactName}, #{city}, #{country}, #{address}, #{postalCode})")
	int insertCustomer(CustomerDto customer);

	@Insert("INSERT INTO Employees "
			+ " (LastName, FirstName, BirthDate, Photo, Notes) "
			+ "VALUES (#{lastName}, #{firstName}, #{birthDate}, #{photo}, #{notes})")
	int insertEmployee(EmployeeDto employee);
	
}
