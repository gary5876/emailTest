package emailSending.dto;

import emailSending.form.QuestionType;
import java.util.List;

public class Answer {
    private String questionId;
    private String label;
    private QuestionType type;
    private String value;          // TEXT/RADIO 값
    private List<String> values;   // CHECKBOX 선택 배열

    public String getQuestionId() { return questionId; }
    public void setQuestionId(String questionId) { this.questionId = questionId; }
    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }
    public QuestionType getType() { return type; }
    public void setType(QuestionType type) { this.type = type; }
    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
    public List<String> getValues() { return values; }
    public void setValues(List<String> values) { this.values = values; }
}
