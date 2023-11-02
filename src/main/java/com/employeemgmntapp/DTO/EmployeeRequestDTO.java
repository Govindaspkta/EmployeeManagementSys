package com.employeemgmntapp.DTO;

public class EmployeeRequestDTO {

    private String firstName;
    private String lastName;
    private String email;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public EmployeeRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EmployeeRequestDTO [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

   
}
