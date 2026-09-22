/**
 * 
 */
package com.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

/**
 * 
 */
public class EmployeeStreamExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Group
		/*groupingBy(Employee::getDepartment)*/
		List<Employee> employees = Arrays.asList(
		        new Employee("30","John", 20000,"IT"),
		        new Employee("21","Ammu", 10000,"Admin"),
		        new Employee("36","Zara", 20000,"IT"),
		        new Employee("36","Theeyara", 20000,"Admin")
		        
		       		);
        groupByDepartment(employees).forEach((department,emplist)->{
        	
        	emplist.forEach(emp->System.out.print("eid:"+emp.getEmpId()
        	+"||name:"+emp.getEmpname()
        	+"||salary:"+emp.getSalary()
        	+"||department:"+emp.getDepartment())
        	);
        	
        });

        
		// Count
		/*groupingBy(Employee::getDepartment, counting())*/
        groupingByCounting(employees).forEach((department, count) -> {
            System.out.println("Department: " + department);
            System.out.println("Employee Count: " + count);
        });;
        	

		// Sum
		/*groupingBy(Employee::getDepartment,
		           summingInt(Employee::getSalary))*/
       
        groupBySummingInt(employees).forEach((department, stats) -> {
            System.out.println("Department: " + department);
            System.out.println("Count   : " + stats.getCount());
            System.out.println("Sum     : " + stats.getSum());
            System.out.println("Min     : " + stats.getMin());
            System.out.println("Max     : " + stats.getMax());
            System.out.println("Average : " + stats.getAverage());
            System.out.println("----------------------");
        });;
		// Average
		/*groupingBy(Employee::getDepartment,
		           averagingInt(Employee::getSalary))*/
        groupByAveragingInt(employees);
         
        groupByAveragingDepartment(employees);
		// Maximum
		/*groupingBy(Employee::getDepartment,
		           maxBy(Comparator.comparingInt(Employee::getSalary)))*/
        groupByMaxbyDepartment(employees);
		// Names
		//groupingBy(Employee::getDepartment,
		          // mapping(Employee::getName, toList()))
         groupngBySummariazeInt(employees);
	}

	private static void groupngBySummariazeInt(List<Employee> employees) {
		// TODO Auto-generated method stub
		Map<String, IntSummaryStatistics> result =
			    employees.stream()
			             .collect(Collectors.groupingBy(
			                 Employee::getDepartment,
			                 Collectors.summarizingInt(Employee::getSalary)
			             ));
		
		result.forEach((department, averageSalary) -> {
		    System.out.println("Summarizing Department: " + department);
		    System.out.println("Summarizing Average Salary: " + averageSalary);
		});
		result.forEach((department, maxSalary)->{
		    System.out.println("Max Department: " + department);
		    System.out.println("max Average Salary: " + maxSalary);
		});
		
	}

	private static void groupByMaxbyDepartment(List<Employee> employees) {
		// TODO Auto-generated method stub
		Map<String, Optional<Employee>> highestByDept =
			    employees.stream()
			             .collect(Collectors.groupingBy(
			                 Employee::getDepartment,
			                 Collectors.maxBy(
			                     Comparator.comparingInt(Employee::getSalary)
			                 )
			             ));
		highestByDept.forEach((dept, emp) ->
	 
	        System.out.println("Maxby Deprtment"+
	            dept 
	        
	    )
	);
	}

	private static void groupByAveragingInt(List<Employee> employees) {
		// TODO Auto-generated method stub
		double averageSalary = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
	    System.out.println("AverageSalary"+averageSalary);
	}
	
	private static Map<String, Double> groupByAveragingDepartment(List<Employee> employees) {
		// TODO Auto-generated method stub
		Map<String, Double> averageSalaryByDept =
			    employees.stream()
			             .collect(Collectors.groupingBy(
			                 Employee::getDepartment,
			                 Collectors.averagingInt(Employee::getSalary)
			             ));
		averageSalaryByDept.forEach((department, averageSalary) ->
	    System.out.println(department + " -> " + averageSalary)
	);
		return averageSalaryByDept;
	}

	private static Map<String, IntSummaryStatistics> groupBySummingInt(List<Employee> employees) {
		// TODO Auto-generated method stub
		Map<String, IntSummaryStatistics> sumInt = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.summarizingInt(Employee::getSalary)));
		return sumInt;
	}

	private static Map<String,Long> groupingByCounting(List<Employee> employees) {
		// TODO Auto-generated method stub
		Map<String, Long> groupbyCount = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
	    return groupbyCount;
	}

	private static Map<String,List<Employee>> groupByDepartment(List<Employee> employees) {
		// TODO Auto-generated method stub
		
		Map<String,List<Employee>> groupbyDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		return groupbyDept;
		
	}

}
