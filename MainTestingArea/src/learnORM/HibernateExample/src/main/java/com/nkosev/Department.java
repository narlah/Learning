package learnORM.HibernateExample.src.main.java.com.nkosev;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Department {

    @Id
    @GeneratedValue
    private Long id;


    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.PERSIST)
    private List<learnORM.HibernateExample.src.main.java.com.nkosev.Employee> employees = new ArrayList<learnORM.HibernateExample.src.main.java.com.nkosev.Employee>();

    public Department() {
        super();
    }

    public Department(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<learnORM.HibernateExample.src.main.java.com.nkosev.Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}