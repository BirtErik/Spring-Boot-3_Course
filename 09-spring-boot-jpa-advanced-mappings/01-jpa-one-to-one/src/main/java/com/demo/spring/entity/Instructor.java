package com.demo.spring.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@ToString(exclude = "id")
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "instructor")
public class Instructor {
    //Not sure if using RequiredArgsConstructor with NonNull is a good practice
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    @NonNull
    private String firstName;

    @Column(name = "last_name")
    @NonNull
    private String lastName;

    @Column(name = "email")
    @NonNull
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetail instructorDetail;
}
