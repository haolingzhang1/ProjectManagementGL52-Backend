package fr.utbm.gl52.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@Table(name = "USER")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "USER_FIRSTNAME", nullable = false)
    private String firstName;

    @Column(name = "USER_LASTNAME", nullable = false)
    private String lastName;

    @Column(name = "USER_EMAIL", nullable = false)
    private String email;

    @Column(name = "USER_PASSWORD", nullable = false)
    private String password;


    //T as teacher,s as student
    @Column(name = "USER_TYPE", nullable = false)
    private String type;

    @Column(name = "PREOJCT_ID")
    private Long projectId;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
//    @OneToMany(mappedBy = "projectId",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
//    private List<ProjectEntity> projectList;
//
//    @Override
//    public String toString(){
//        return "user id: "+userId+" first name: "+firstName+"last name: "+lastName+" email:"+email
//                +" password: "+password+" type: "+type;
//    }

}
