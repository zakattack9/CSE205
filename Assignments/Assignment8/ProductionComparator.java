import java.util.Comparator;

// Assignment #: 8
//         Name: Zak Sakata
//    StudentID: 1214985785
//      Lecture: 10:30am
//  Description: Compares two production companies and determines which one is first alphabetically

public class ProductionComparator implements Comparator<Movie> {
  public int compare(Movie first, Movie second) {
    String firstProdState = first.getProdCompany().getLocationState();
    String secondProdState = second.getProdCompany().getLocationState();
    String firstProdCity = first.getProdCompany().getLocationCity();
    String secondProdCity = second.getProdCompany().getLocationCity();
    int result;

    if (firstProdState.compareTo(secondProdState) < 0) {
      result = -1;
    } else if (firstProdState.compareTo(secondProdState) > 0) {
      result = 1;
    } else {
      if (firstProdCity.compareTo(secondProdCity) < 0) {
        result = -1;
      } else if (firstProdCity.compareTo(secondProdCity) > 0) {
        result = 1;
      } else {
        result = 0;
      }
    }

    return result;
  }
}