    package com.example.ApiClassRoom.models;

    import com.fasterxml.jackson.annotation.JsonManagedReference;
    import com.fasterxml.jackson.annotation.JsonBackReference;
    import jakarta.persistence.*;
    import java.util.List;

    @Entity
    @Table(name = "teachers")  // usa minúsculas y plural, para seguir convención

    public class Teacher {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "teacher_id")
        private Integer id;

        @Column(nullable = false, length = 100)
        private String skill;

        // Relación con User (FK id_usuario)
        @OneToOne// Muchos docentes pueden asociarse a un usuario, o si es 1 a 1, usar @OneToOne
        @JoinColumn(name = "fk_user", referencedColumnName = "user_id")
        @JsonBackReference(value = "teacher-user")  // para evitar ciclos en JSON (marca el lado "hijo")
        private User user;

        // Relación con Courses
        @OneToMany(mappedBy = "teacher")
        @JsonManagedReference(value= "teacher-course")
        private List<Course> courses;

        public Teacher() {
        }

        public Teacher(Integer id, String skill, User user, List<Course> courses) {
            this.id = id;
            this.skill = skill;
            this.user = user;
            this.courses = courses;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getSkill() {
            return skill;
        }

        public void setSkill(String skill) {
            this.skill = skill;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public List<Course> getCourses() {
            return courses;
        }

        public void setCourses(List<Course> courses) {
            this.courses = courses;
        }
    }
