package fr.utbm.gl52.entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Data
@Table(name = "WORK")
public class WorkEntity implements Serializable {
//
//    @Id
//    @JoinColumn(name="PROJECT_ID")
//    private ProjectEntity project;
//
//    @Id
//    @JoinColumn(name="USER_ID")
//    private UserEntity user;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WORK_ID", nullable = false)
    private Long workId;

    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "PROJECT_ID", nullable = false)
    private Long projectId;

}
