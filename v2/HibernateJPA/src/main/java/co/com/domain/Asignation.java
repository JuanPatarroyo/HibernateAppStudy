/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author jpatarroyo
 */
@Entity
public class Asignation implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id_asignation")
    private Integer idAsignation;
    @ManyToOne
    @JoinColumn(name = "id_student", referencedColumnName = "id_student")
    private Student idStudent;
    @ManyToOne
    @JoinColumn(name = "id_course", referencedColumnName = "id_course")
    private Course idCourse;
    private String schedule;

    public Asignation() {
    }

    public Asignation(Integer idAsignation) {
        this.idAsignation = idAsignation;
    }

    public Integer getIdAsignation() {
        return idAsignation;
    }

    public void setIdAsignation(Integer idAsignation) {
        this.idAsignation = idAsignation;
    }

    public Student getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Student idStudent) {
        this.idStudent = idStudent;
    }

    public Course getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Course idCourse) {
        this.idCourse = idCourse;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "Asignation{" + "idAsignation=" + idAsignation + ", idStudent=" + idStudent + ", idCourse=" + idCourse + ", schedule=" + schedule + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.idAsignation);
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
        final Asignation other = (Asignation) obj;
        if (!Objects.equals(this.idAsignation, other.idAsignation)) {
            return false;
        }
        return true;
    }
}
