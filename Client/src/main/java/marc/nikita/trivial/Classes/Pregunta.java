package marc.nikita.trivial.Classes;

import com.google.gson.Gson;

import java.util.List;

public class Pregunta {
    private String type;
    private String difficulty;
    private String category;
    private String question;
    private String correct_answer;
    private List<String> incorrect_answers;

    // Instancia de Gson para convertir objetos a JSON y viceversa.
    private static Gson gson = new Gson();

    // Inicializa el tipo, la dificultad, la categoría, el texto de la pregunta, la respuesta correcta y las respuestas incorrectas.
    public Pregunta(String type, String difficulty, String category, String question, String correct_answer, List<String> incorrect_answers) {
        this.type = type;
        this.difficulty = difficulty;
        this.category = category;
        this.question = question;
        this.correct_answer = correct_answer;
        this.incorrect_answers = incorrect_answers;
    }

    public Pregunta() {

    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correct_answer;
    }

    public List<String> getIncorrectAnswers() {
        return incorrect_answers;
    }
}
