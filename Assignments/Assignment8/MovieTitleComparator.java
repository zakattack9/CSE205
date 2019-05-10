import java.util.Comparator;

// Assignment #: 8
//         Name: Zak Sakata
//    StudentID: 1214985785
//      Lecture: 10:30am
//  Description: Compares two movie titles and determines which title is first alphabetically

public class MovieTitleComparator implements Comparator<Movie> {
  public int compare(Movie first, Movie second) {
    int result;

    if (first.getMovieTitle().compareTo(second.getMovieTitle()) < 0) {
      result = -1;
    } else if (first.getMovieTitle().compareTo(second.getMovieTitle()) > 0){
      result = 1;
    } else {
      result = 0;
    }

    return result;
  }
}