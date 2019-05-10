public class Production {
  private String companyName;
  private String locationCity;
  private String locationState;

  public Production () {
    companyName = "?";
    locationCity = "?";
    locationState = "?";
  }

  public String getCompanyName() {
    return companyName;
  }

  public String getLocationCity() {
    return locationCity;
  }

  public String getLocationState() {
    return locationState;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public void setLocationCity(String locationCity) {
    this.locationCity = locationCity;
  }

  public void setLocationState(String locationState) {
    this.locationState = locationState;
  }

  public String toString() {
    return companyName + " at " + locationCity + "," + locationState;
  }
}