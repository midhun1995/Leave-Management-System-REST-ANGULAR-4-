package com.hexaware.ftp07.model;

import com.hexaware.ftp07.persistence.DbConnection;
import com.hexaware.ftp07.persistence.EmployeeDAO;

import java.util.Objects;
import java.util.List;

/**
 * Employee class to store employee personal details.
 * @author hexware
 */
public class Employee {

  /**
   * empId to store employee id.
   */
  private int empId;

  /**
   * empName to store employee name.
   */
  private String empName;

  /**
   * empMail to store employee mail.
   */
  private String empMail;

  /**
   * empPhone to store employee phone.
   */
  private String empPhone;

  /**
   * empDoj to store employee date of joining.
   */
  private String empDoj;

  /**
   * empLeaveBalance to store employee leave balance.
   */
  private int empLeaveBalance;

  /**
   * empDept to store employee department name.
   */
  private String empDept;

  /**
   * empMgrId to store employee manager id.
   */
  private int empMgrId;


  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Employee emp = (Employee) obj;
    if (Objects.equals(empId, emp.empId)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(empId);
  }

  /**
   * @param argEmpId to initialize employee id.
   */
  public Employee(final int argEmpId) {
    this.empId = argEmpId;
  }

  /**
   * Gets the EmployeeId.
   * @return this Employee's ID.
   */
  public final int getEmpId() {
    return empId;
  }

  /**
   *
   * @param argEmpId to set employee id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }

  /**
   * Gets the EmployeeName.
   * @return this Employee's Name.
   */
  public final String getEmpName() {
    return empName;
  }

  /**
   *
   * @param argEmpName to set employee Name.
   */
  public final void setEmpName(final String argEmpName) {
    this.empName = argEmpName;
  }

  /**
   * Gets the EmployeeMail.
   * @return this Employee's Mail.
   */
  public final String getEmpMail() {
    return empMail;
  }

  /**
   *
   * @param argEmpMail to set employee mail.
   */
  public final void setEmpMail(final String argEmpMail) {
    this.empMail = argEmpMail;
  }

  /**
   * Gets the EmployeePhone.
   * @return this Employee's Phone.
   */
  public final String getEmpPhone() {
    return empPhone;
  }

  /**
   *
   * @param argEmpPhone to set employee phone.
   */
  public final void setEmpPhone(final String argEmpPhone) {
    this.empPhone = argEmpPhone;
  }

  /**
   * Gets the EmployeeDoj.
   * @return this Employee's Date Of Joining.
   */
  public final String getEmpDoj() {
    return empDoj;
  }

  /**
   *
   * @param argEmpDoj to set employee date of joining.
   */
  public final void setEmpDoj(final String argEmpDoj) {
    this.empDoj = argEmpDoj;
  }

  /**
   * Gets the EmployeeLeaveBalance.
   * @return this Employee's Leave Balance.
   */
  public final int getEmpLeaveBalance() {
    return empLeaveBalance;
  }

  /**
   *
   * @param argEmpLeaveBalance to set employee leave balance.
   */
  public final void setEmpLeaveBalance(final int argEmpLeaveBalance) {
    this.empLeaveBalance = argEmpLeaveBalance;
  }

  /**
   * Gets the EmployeeDepartment.
   * @return this Employee's Department.
   */
  public final String getEmpDept() {
    return empDept;
  }

  /**
   *
   * @param argEmpDept to set employee employee department.
   */
  public final void setEmpDept(final String argEmpDept) {
    this.empDept = argEmpDept;
  }

  /**
   * Gets the EmployeeManagerId.
   * @return this Employee's Manager Id.
   */
  public final int getEmpMgrId() {
    return empMgrId;
  }

  /**
   *
   * @param argEmpMgrId to set employee manager id.
   */
  public final void setEmpMgrId(final int argEmpMgrId) {
    this.empMgrId = argEmpMgrId;
  }

  /**
   * The dao for employee.
   */
  private static EmployeeDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }

  /**
   * list all employee details.
   * @return all employees' details
   */
  public static Employee[] listAll() {

    List<Employee> es = dao().list();
    return es.toArray(new Employee[es.size()]);
  }

  /**
   * list employee details by id.
   * @param empID id to get employee details.
   * @return Employee
   */
  public static Employee listById(final int empID) {
    return dao().find(empID);
  }

}
