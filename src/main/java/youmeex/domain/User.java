package youmeex.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	Long id;
	
	@Column(name="userId", nullable=false, unique=true, length=25)
	String userId;
	@Column(name="password", nullable=false, unique=false, length=20)
	String password;
	@Column(name="name", nullable=false, unique=false, length=40)
	String name;
	@Column(name="mail", nullable=false, unique=true, length=40)
	String email;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", name=" + name + ", email=" + email + "]";
	}

	public void update(User updateUser) {
		 this.userId = updateUser.userId;
         this.password = updateUser.password;
         this.name = updateUser.name;
         this.email = updateUser.email;
         
         
	}

}
