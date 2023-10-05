import java.util.List;

import controller.UserHelper;
import model.User;

/**
 * @author Kenneth Nimmo - Knimmo CIS175 - Fall 2021 Oct 3, 2023
 */
public class UserTester {

	public static void main(String[] args) {
		User mark = new User("Mark");
		User sarah = new User("Sarah");

		UserHelper uh = new UserHelper();

		uh.insertUser(mark);
		uh.insertUser(sarah);

		List<User> allUsers = uh.showAllUsers();
		for (User u : allUsers) {
			System.out.println(u.toString());
		}
	}
}
