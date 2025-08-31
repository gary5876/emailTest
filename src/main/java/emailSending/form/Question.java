package emailSending.form;

import java.util.List;

public class Question {
    private final String id;             // "q1", "availableDays" 등
    private final String label;          // 질문 문구
    private final QuestionType type;     // TEXT | CHECKBOX | RADIO
    private final boolean required;
    private final int order;
    private final List<String> options;  // CHECKBOX/RADIO일 때만 사용

    public Question(String id, String label, QuestionType type, boolean required, int order, List<String> options) {
        this.id = id; this.label = label; this.type = type; this.required = required; this.order = order; this.options = options;
    }
    public String getId() { return id; }
    public String getLabel() { return label; }
    public QuestionType getType() { return type; }
    public boolean isRequired() { return required; }
    public int getOrder() { return order; }
    public List<String> getOptions() { return options; }
}