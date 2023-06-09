package com.example.login.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
/*
@Getter and @Setter: These annotations are
 from the Lombok library and automatically
 generate getter and setter methods for all the class's fields.
* */
@NoArgsConstructor
/*@NoArgsConstructor: This annotation is from
Lombok and generates a no-argument constructor for the class.
 */
@AllArgsConstructor
@Entity
/*@Entity: This annotation is from the Java Persistence API (JPA)
 and specifies that the class is a JPA entity, meaning that it is
  mapped to a database table.
 */
@Table(name="users")
/*@Table(name="users"): This annotation is from JPA and specifies
the name of the database table that the entity is mapped to.
 */
public class user {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*@GeneratedValue(strategy = GenerationType.IDENTITY): This annotation is from
    JPA and specifies that the primary key values are automatically generated by the
    database using an identity column.
     */
    private Long id;
    /*@Column(nullable=false): These annotations are from JPA and
    specify that the fields name, email, and password cannot be null
     in the database table.
    @Column(nullable=false, unique=true): This annotation is from JPA and specifies
     that the email field must be unique in the database table. */
    @Column(nullable=false)
    private String name;

    @Column(nullable=false,unique=true)
    private String email;

    @Column(nullable=false)
    private String password;
    /*@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL): This annotation is
     from JPA and specifies that the relationship between User and Role entities is many-to-many.

@JoinTable: This annotation is from JPA and specifies the details of the join table that is used to
implement the many-to-many relationship between User and Role entities. It specifies the name of the join
table (users_roles) and the names of the foreign key columns in the join table (USER_ID and ROLE_ID).*/
    @ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_roles",
            joinColumns = {@JoinColumn(name = "USER_ID",referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID",referencedColumnName = "ID")}
    )
    private List<role> roles = new ArrayList<>();
}
