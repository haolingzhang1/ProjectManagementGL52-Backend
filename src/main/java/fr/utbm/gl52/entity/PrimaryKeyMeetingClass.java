package fr.utbm.gl52.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PrimaryKeyMeetingClass implements Serializable {

    private Date meetingStart ;
    private Date meetingEnd ;

}
