public interface Employee extends  Comparable<Employee>{
    int getMoneySalary();

    @Override
    default int compareTo(Employee e) {
        return getMoneySalary() - e.getMoneySalary();
    }
}

