package fr.utbm.gl52.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Data
@Entity
@Table(name = "DOCUMENT")
//@EqualsAndHashCode(callSuper = true)
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class DocumentEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DOCUMENT_ID", nullable = false)
    private Long documentId;

    @Column(name = "DOCUEMENT_TITLE", nullable = false)
    private String documentTitle;

    @Column(name = "DOCUMENT_TYPE", nullable = false)
    private String documentType;

    @CreatedDate
    @Column(name = "DOCUMENT_CREATION", nullable = false)
    private Date documentCreation;

    @LastModifiedDate
    @Column(name = "DOCUMENT_MODIFICATION", nullable = false)
    private Date documentModification;

    @Column(name = "PROJECT_ID", nullable = false)
    private Long projectId;



//    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
//    @JoinColumn(name="PROJECT_ID")
//    private ProjectEntity project;
//
//    @Override
//    public String toString(){
//        return "document id is : "+documentId+" title:"+documentTitle+" type: "+documentType
//                +" create at: "+documentCreation+" modify at :"+documentModification;
//    }

}
