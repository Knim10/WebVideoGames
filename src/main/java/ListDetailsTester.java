import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import model.ListDetails;
import model.User;
import model.VideoGame;

/**
 * @author Kenneth Nimmo - Knimmo CIS175 - Fall 2021 Oct 3, 2023
 */
public class ListDetailsTester {

	public static void main(String[] args) {
		User Octavian = new User("Octavian");

		ListDetailsHelper ldh = new ListDetailsHelper();

		VideoGame witcher = new VideoGame("Steam", "Witcher 3", 59.99);
		VideoGame satisfactory = new VideoGame("Epic Games", "Satisfactory", 39.99);

		List<VideoGame> octaviansItems = new ArrayList<VideoGame>();
		octaviansItems.add(witcher);
		octaviansItems.add(satisfactory);

		ListDetails octaviansList = new ListDetails("Octavians VideoGames List", Octavian);
		octaviansList.setListOfGames(octaviansItems);

		ldh.insertNewListDetails(octaviansList);

		List<ListDetails> allLists = ldh.getLists();

		for (ListDetails a : allLists) {
			System.out.println(a.toString());
		}
	}

}
