package Candidate;

import java.io.Serializable;
import java.util.IllformedLocaleException;

public abstract class Candidate implements Serializable {
    private static final long serialVersionUID = 1L;

	private String firstname;
	
	private String lastname;
	
	private String phone;
	
	private String email;
	
	public abstract String getType();

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		if(!phone.matches("\\d+")) {
			throw new IllegalArgumentException("Phone chi duoc chua so");
		}
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(email==null||email.trim().isEmpty()) {
			throw new IllegalArgumentException("Email khong duoc de trong");
		}
		this.email = email;
	}

	@Override
	public String toString() {
		return "Candidate [firstname=" + firstname + ", lastname=" + lastname + ", phone=" + phone + ", email=" + email
				+ "]";
	}

	public Candidate(String firstname, String lastname, String phone, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.email = email;
	}
	
	
	
	
}
