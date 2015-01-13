package com.tedneward.example;

import java.beans.*;
import java.util.*;
import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;


public class Person implements Comparable<Person> {
  private int age;
  private String name;
  private double salary;
  private String ssn;
  private boolean propertyChangeFired = false;
  static private final AtomicInteger count = new AtomicInteger();

  {
    count.getAndIncrement();
  }

  static public int count() {
    return count.get();
  }

  public Person() {
    this("", 0, 0.0d);
  }
  
  public Person(String n, int a, double s) {
    name = n;
    age = a;
    salary = s;
  }

  public String toString() {
    return String.format("[Person name:%s age:%d salary:%.2f]", name, age, salary);
  }

  public int getAge() {
    return age;
  }
  public void setAge(int newAge) {
    if (newAge < 0) {
      throw new IllegalArgumentException();
    }
    this.age = newAge;
  }
  
  public String getName() {
    return name;
  }
  public void setName(String newName) {
    if (newName == null) {
      throw new IllegalArgumentException();
    }
    this.name = newName;
  }

  public double getSalary() { return salary; }
  public void setSalary(double newSalary) {
    if (newSalary < 0) {
      throw new IllegalArgumentException();
    }
    this.salary = newSalary;
  }

  public String getSSN() {
    return ssn;
  }
  public void setSSN(String value) {
    String old = ssn;
    ssn = value;
    
    this.pcs.firePropertyChange("ssn", old, value);
    propertyChangeFired = true;
  }
  public boolean getPropertyChangeFired() {
    return propertyChangeFired;
  }

  public double calculateBonus() {
    return salary * 1.10;
  }
  
  public String becomeJudge() {
    return "The Honorable " + name;
  }
  
  public int timeWarp() {
    return age + 10;
  }

  @Override
  public boolean equals(Object other) {
    try {
      if (other != null && other instanceof Person) {
        Person per = (Person)other;
        return (this.name.equals(per.getName()) && this.age == per.getAge());
      } else {
        return false;
      }
    }
    catch (Exception ex) {
      ex.printStackTrace();
      return false;
    }
  }

  public static List<Person> getNewardFamily() {
    Person p1 = new Person("Ted", 41, 250000);
    Person p2 = new Person("Charlotte", 43, 150000);
    Person p3 = new Person("Michael", 22, 10000);
    Person p4 = new Person("Matthew", 15, 0);

    List<Person> family = new ArrayList<Person>();
    family.add(p1);
    family.add(p2);
    family.add(p3);
    family.add(p4);

    return family;
  }



  @Override
  public int compareTo(Person other) {
    Person p = (Person)other;
    return (int)(p.getSalary() - this.getSalary());
  }

  public static class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
      return p1.getAge() - p2.getAge();
    }
  }

  // PropertyChangeListener support; you shouldn't need to change any of
  // these two methods or the field
  //
  private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
  public void addPropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.addPropertyChangeListener(listener);
  }
  public void removePropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.removePropertyChangeListener(listener);
  }
}

