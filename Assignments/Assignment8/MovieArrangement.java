import java.io.Serializable;

// Assignment #: 8
//         Name: Zak Sakata
//    StudentID: 1214985785
//      Lecture: 10:30am
//  Description: Arranges movies in designated order

public class MovieArrangement implements Serializable {
  private Movie[] movieList;
  private int currentMoviesCount;
  private int maxSize;

  public MovieArrangement(int maxSize) {
    this.maxSize = maxSize;
    movieList = new Movie[maxSize];
    currentMoviesCount = 0;
  }
  
  public int movieExists(String movieTitle, int year) {
    int result = -1;

    for (int i = 0; i < currentMoviesCount; i++) {
      if (movieList[i].getMovieTitle().equals(movieTitle) && movieList[i].getYear() == year) {
        result = i;
        break;
      }
    }
    
    return result;
  }

  public int productionExists(String companyName, String locationCity, String locationState) {
    int result = -1;

    for (int i = 0; i < currentMoviesCount; i++) {
      Production currProd = movieList[i].getProdCompany();
      if (currProd.getCompanyName().equals(companyName) && currProd.getLocationCity().equals(locationCity) && currProd.getLocationState().equals(locationState)) {
        result = i;
        break;
      }
    }
    
    return result;
  }

  public boolean addMovie(String title, int length, int year, String companyName, String locationCity, String locationState) {
    if (this.movieExists(title, year) == -1) {
      if (currentMoviesCount != maxSize) {
        Movie newMovie = new Movie();
        newMovie.setMovieTitle(title);
        newMovie.setLength(length);
        newMovie.setYear(year);
        newMovie.setProdCompany(companyName, locationCity, locationState);

        movieList[currentMoviesCount] = newMovie;
        currentMoviesCount++;
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  public boolean removeMovie(String movieTitle, int year) {
    if (this.movieExists(movieTitle, year) != -1) {
      int movieExistsIndex = this.movieExists(movieTitle, year);
      movieList[movieExistsIndex] = null;

      for (int i = movieExistsIndex; i < currentMoviesCount; i++) {
        movieList[i] = movieList[i + 1];
        movieList[i + 1] = null;
      }
      currentMoviesCount--;
      return true;
    } else {
      return false;
    }
  }

  public void sortByMovieTitles() {
    Sorts.sort(movieList, currentMoviesCount, new MovieTitleComparator());
  }

  public void sortByMovieYears() {
    Sorts.sort(movieList, currentMoviesCount, new MovieYearComparator());
  }

  public void sortByProductions() {
    Sorts.sort(movieList, currentMoviesCount, new ProductionComparator());
  }

  public String listMovies() {
    String result = "";
    
    if (currentMoviesCount != 0) {
      String listString = "\n";
      for (int i = 0; i < currentMoviesCount; i++) {
        listString += movieList[i];
      }
      result = listString + "\n";
    } else {
      result = "\nno movie\n\n";
    }

    return result;
  }

  public void closeMovieArrangement() {
    for (int i = 0; i < currentMoviesCount; i++) {
      movieList[i] = null;
    }
    currentMoviesCount = 0;
  }
}