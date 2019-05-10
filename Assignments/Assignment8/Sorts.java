import java.util.Comparator;

// Assignment #: 8
//         Name: Zak Sakata
//    StudentID: 1214985785
//      Lecture: 10:30am
//  Description: Sorts movie list in alphabetical order

public class Sorts {
  public static void sort(Movie[] movieList, int size, Comparator<Movie> c) {
    int min;

    for (int i = 0; i < size - 1; i++) {
      min = i;

      for (int scan = i + 1; scan < size; i++) {
        if (c.compare(movieList[scan], movieList[min]) < 0) {
          min = scan;
        }
      }

      Movie tempMovie = movieList[i];
      movieList[i] = movieList[min];
      movieList[min] = tempMovie;
    }

  }
}