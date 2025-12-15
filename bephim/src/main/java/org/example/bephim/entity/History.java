package org.example.bephim.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date viewingTime; //thời gian xem video

    private Integer durationViewed; //thời lượng đã xem

    private String status;

    private Integer completionRate; //tỉ lệ hoàn thành %

    @UpdateTimestamp
    private Date updateDated;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "linkVideoId",referencedColumnName = "id")
    private LinkVideo linkVideo;

}
