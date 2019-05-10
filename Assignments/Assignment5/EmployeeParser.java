public class EmployeeParser {
  public Employee parseStringToEmployee (String lineToParse) {
    Employee parsedEmployee = null;
    String[] parsedString = lineToParse.split(":");
    String parsedFirstName = parsedString[1];
    String parsedLastName = parsedString[2];
    String parsedEmployeeId = parsedString[3];
    
    if (parsedString[0].toUpperCase().equals("FULLTIME")) {
      double parsedSalary = Double.parseDouble(parsedString[4]);
      double parsedBonus = Double.parseDouble(parsedString[5]);
      parsedEmployee = new FullTimeEmployee(parsedFirstName, parsedLastName, parsedEmployeeId, parsedSalary, parsedBonus);
    
    } else if (parsedString[0].toUpperCase().equals("PARTTIME")) {
      double parsedHourlyRate = Double.parseDouble(parsedString[4]);
      int parsedHours = Integer.parseInt(parsedString[5]);
      parsedEmployee = new PartTimeEmployee(parsedFirstName, parsedLastName, parsedEmployeeId, parsedHourlyRate, parsedHours);

    }

    return parsedEmployee;
  }
}