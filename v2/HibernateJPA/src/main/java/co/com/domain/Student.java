/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author jpatarroyo
 */
@Entity
public class Student implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id_student")
    private Integer idStudent;
    @ManyToOne
    @JoinColumn(name = "id_address", referencedColumnName = "id")
    private Address idAddress;
    @ManyToOne
    @JoinColumn(name = "id_contact", referencedColumnName = "id_contact")
    private Contact idContact;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @OneToMany(mappedBy = "idStudent")
    private List<Asignation> asignations;

    public Student() {
    }

    public Student(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public Address getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Address idAddress) {
        this.idAddress = idAddress;
    }

    public Contact getIdContact() {
        return idContact;
    }

    public void setIdContact(Contact idContact) {
        this.idContact = idContact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Asignation> getAsignations() {
        return asignations;
    }

    public void setAsignations(List<Asignation> asignations) {
        this.asignations = asignations;
    }

    @Override
    public String toString() {
        return "Student{" + "idStudent=" + idStudent + ", idAddress=" + idAddress + ", idContact=" + idContact + ", name=" + name + ", lastName=" + lastName + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.idStudent);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.idStudent, other.idStudent)) {
            return false;
        }
        return true;
    }
}
