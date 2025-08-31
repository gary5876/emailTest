package emailSending.exampleQuestions;

import emailSending.form.Question;
import emailSending.form.QuestionType;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FormSchemaService {

    public List<Question> getQuestions() {
        return List.of(
                new Question("paragraph1", "자기소개 1", QuestionType.TEXT, true, 1, null),
                new Question("paragraph2", "자기소개 2", QuestionType.TEXT, true, 2, null),
                new Question("availableDays", "가능 요일(복수선택)", QuestionType.CHECKBOX, false, 3,
                        List.of("월", "화", "수", "목", "금", "토", "일")),
                new Question("level", "경력 수준", QuestionType.RADIO, true, 4,
                        List.of("입문", "주니어", "미들", "시니어"))
        );
    }
}
