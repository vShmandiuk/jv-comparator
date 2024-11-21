package core.basesyntax;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class EmployeeService {
    public Set<Employee> getEmployByOrder(List<Employee> employees) {
        if (employees == null) {
            throw new IllegalArgumentException("Input list cannot be null");
        }
        Comparator<Employee> employeeComparator = new Comparator<>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int ageCompared = Integer.compare(o1.getAge(), o2.getAge());
                if (ageCompared != 0) {
                    return ageCompared;
                }
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        };

        Set<Employee> sortedEmployees = new TreeSet<>(employeeComparator);
        sortedEmployees.addAll(employees);

        return sortedEmployees;
    }
}
