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

//    @OneToMany(mappedBy = "projectId",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
//    private List<ProjectEntity> projectList;
//
//    @Override
//    public String toString(){
//        return "user id: "+userId+" first name: "+firstName+"last name: "+lastName+" email:"+email
//                +" password: "+password+" type: "+type;
//    }

}
