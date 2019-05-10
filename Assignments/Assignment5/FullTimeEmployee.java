public class FullTimeEmployee extends Employee {
  private double salary;
  private double bonus;

  public FullTimeEmployee (String firstName, String lastName, String employeeId, double salary, double bonus) {
    super(firstName, lastName, employeeId);
    this.salary = salary;
    this.bonus = bonus;
  }

  public void computePayAmount () {
    super.payAmount = salary + bonus;
  }

  public String toString () {
   return "\nFull Time Employee:" + super.toString() + "\nSalary:\t\t\t" + super.usd.format(salary) + "\nBonus:\t\t\t" + super.usd.format(bonus) + "\n";
  }
}