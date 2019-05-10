import java.util.Comparator;

// Assignment #: 8
//         Name: Zak Sakata
//    StudentID: 1214985785
//      Lecture: 10:30am
//  Description: Compares two movie years and determines which one is first

public class MovieYearComparator implements Comparator<Movie> {
  public int compare(Movie first, Movie second) {
    int result;

    if (first.getYear() - second.getYear() < 0) {
      result = -1;
    } else if (first.getYear() - second.getYear() > 0){
      result = 1;
    } else {
      result = 0;
    }

    return result;
  }
}