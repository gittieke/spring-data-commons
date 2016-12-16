package be.jslm.exercises;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {

  private @Id @GeneratedValue Long id;
  private String firstName, lastName, description;

  private Employee() {}

  public Employee(String firstName, String lastName, String description) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.description = description;
  }
  
  @Override
  public String toString(){
	  return String.format("Employee[id=%d, firstName='%s' lastName='%s'",id, firstName, lastName);
  }
  
  @Override
	public boolean equals(Object obj) {		
		return super.equals(obj);
	}
  
}