import java.text.NumberFormat; //import NumberFormat

public abstract class Employee {
  protected NumberFormat usd = NumberFormat.getCurrencyInstance();
  protected String firstName;
  protected String lastName;
  protected String employeeId;
  protected double payAmount;

  public Employee (String firstName, String lastName, String employeeId) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.employeeId = employeeId;
    payAmount = 0.0;
  }

  public String getEmployeeId () {
    return employeeId;
  }

  public abstract void computePayAmount ();

  public String toString () {
    return "\nFirst name:\t\t" + firstName + "\nLast name:\t\t" + lastName + "\nEmployee ID:\t\t" + employeeId + "\nPay Amount:\t\t" + usd.format(payAmount);
  }
}