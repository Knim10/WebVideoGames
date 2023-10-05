package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Kenneth Nimmo - Knimmo CIS175 - Fall 2021 Oct 3, 2023
 */
@Entity
public class ListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private User userName;
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private List<VideoGame> listOfGames;

	/**
	 * 
	 */
	public ListDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param listName
	 * @param userName
	 * @param listOfGames
	 */
	public ListDetails(int id, String listName, User userName, List<VideoGame> listOfGames) {
		super();
		this.id = id;
		this.listName = listName;
		this.userName = userName;
		this.listOfGames = listOfGames;
	}

	/**
	 * @param listName
	 * @param userName
	 * @param listOfGames
	 */
	public ListDetails(String listName, User userName, List<VideoGame> listOfGames) {
		super();
		this.listName = listName;
		this.userName = userName;
		this.listOfGames = listOfGames;
	}

	/**
	 * @param listName
	 * @param userName
	 */
	public ListDetails(String listName, User userName) {
		super();
		this.listName = listName;
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
	 * @return the listName
	 */
	public String getListName() {
		return listName;
	}

	/**
	 * @param listName the listName to set
	 */
	public void setListName(String listName) {
		this.listName = listName;
	}

	/**
	 * @return the userName
	 */
	public User getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(User userName) {
		this.userName = userName;
	}

	/**
	 * @return the listOfGames
	 */
	public List<VideoGame> getListOfGames() {
		return listOfGames;
	}

	/**
	 * @param listOfGames the listOfGames to set
	 */
	public void setListOfGames(List<VideoGame> listOfGames) {
		this.listOfGames = listOfGames;
	}

	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", userName=" + userName + ", listOfGames="
				+ listOfGames + "]";
	}

}
