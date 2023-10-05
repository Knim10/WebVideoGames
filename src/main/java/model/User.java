package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Kenneth Nimmo - Knimmo CIS175 - Fall 2021 Oct 3, 2023
 */
@Entity
@Table(name = "User")
public class User {
	@Id
	@GeneratedValue
	private int id;
	private String userName;

	/**
	 * 
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param userName
	 */
	public User(String userName) {
		super();
		this.userName = userName;
	}

	/**
	 * @param id
	 * @param userName
	 */
	public User(int id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + "]";
	}

}
