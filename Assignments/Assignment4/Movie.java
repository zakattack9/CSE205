public class Movie {
  private String movieTitle;
  private int year;
  private int length;
  private Production prodCompany;

  public Movie () {
    movieTitle = "?";
    year = 0;
    length = 0;
  }

  public String getMovieTitle () {
    return movieTitle;
  }

  public int getYear () {
    return year;
  }

  public int getLength () {
    return length;
  }

  public Production getProdCompany () {
    return prodCompany;
  }

  public void setMovieTitle (String movieTitle) {
    this.movieTitle = movieTitle;
  }

  public void setYear (int year) {
    this.year = year;
  }

  public void setLength (int length) {
    this.length = length;
  }

  public void setProdCompany (String prodName, String prodCity, String prodState) {
    prodCompany = new Production();
    this.prodCompany.setCompanyName(prodName);
    this.prodCompany.setLocationCity(prodCity);
    this.prodCompany.setLocationState(prodState);
  }

  public String toString() {
    return "\nMovie Title:\t\t" + movieTitle + "\nMovie Length:\t\t" + length + "\nMovie Year:\t\t" + year + "\nMovie Production:\t" + prodCompany + "\n\n";
  }

}