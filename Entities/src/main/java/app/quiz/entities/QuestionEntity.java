package app.quiz.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "QUESTION")
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "QUESTION")
    private String question;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QUIZ",referencedColumnName = "ID")
    private QuizEntity quiz;
}
