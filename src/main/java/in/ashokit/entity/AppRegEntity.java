package in.ashokit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="AR_APP_REG")
@Data
public class AppRegEntity {
	
	@Id
	@GeneratedValue
	@Column(name ="APP_NUM")
	private Integer appNum;
	
	@Column(name ="FULL_NAME")
	private String fullname;
	
	@Column(name ="EMAIL")
	private String email;
	
	@Column(name ="PHONE_NUM")
	private String phonNum;
	
	@Column(name ="DOB")
	private String dob;
	
	@Column(name ="GENDER")
	private String gender;
	
	@Column(name ="SSN")
	private String ssn;

}
