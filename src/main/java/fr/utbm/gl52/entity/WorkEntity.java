package fr.utbm.gl52.entity;
import lombok.Data;
import org.apache.catalina.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "WORK")
public class WorkEntity implements Serializable {

    @JoinColumn(name="PROJECT_ID")
    private ProjectEntity project;

    @JoinColumn(name="USER_ID")
    private UserEntity user;


}
