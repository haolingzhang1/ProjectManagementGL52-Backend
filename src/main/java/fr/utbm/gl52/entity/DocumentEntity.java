package fr.utbm.gl52.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "DOCUMENT")
@IdClass(PrimaryKeyMeetingClass.class)
@EqualsAndHashCode(callSuper = true)
@DynamicUpdate
@DynamicInsert
public class DocumentEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DOCUMENT_ID", nullable = false)
    private Long documentId;

    @Column(name = "DOCUEMENT_TITLE", nullable = false)
    private String documentTitle;

    @Column(name = "DOCUMENT_TYPE", nullable = false)
    private String documentType;

    @Column(name = "DOCUMENT_CREATION", nullable = false)
    private Date documentCreation;

    @Column(name = "DOCUMENT_MODIFICATION", nullable = false)
    private Date documentModification;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="PROJECT_ID")
    private ProjectEntity project;

    @Override
    public String toString(){
        return "document id is : "+documentId+" title:"+documentTitle+" type: "+documentType
                +" create at: "+documentCreation+" modify at :"+documentModification;
    }

}
