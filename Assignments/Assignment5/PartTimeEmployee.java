public class PartTimeEmployee extends Employee {
  private double hourlyRate;
  private int hours;

  public PartTimeEmployee (String firstName, String lastName, String employeeId, double hourlyRate, int hours) {
    super(firstName, lastName, employeeId);
    this.hourlyRate = hourlyRate;
    this.hours = hours;
  }

  public void computePayAmount () {
    super.payAmount = hourlyRate * hours;
  }

  public String toString () {
    return "\nPart Time Employee:" + super.toString() + "\nHourlyRate:\t\t" + super.usd.format(hourlyRate) + "\nHours:\t\t\t" + hours + "\n";
  }
}