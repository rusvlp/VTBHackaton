package com.example.demo.entites;

import com.example.demo.enums.RussianMonth;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "dateOfStart")
    private LocalDate dateOfStart;

    @Column(name = "seasonPassXpValue")
    private Integer seasonPassXpValue;

    @Column(name = "cryptoValue")
    private Long cryptoValue;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<User> participantList;

    public String getFormattedDate(){
        String res = "";
        res += dateOfStart.getDayOfMonth() +
                " " + RussianMonth.values()[dateOfStart.getMonthValue() - 1].getTitle() +
                " " + dateOfStart.getYear();
        return res;
    }

}
