package score;

import statement.StatementCategory;

public class ScoreSet {
    
    private String category;
    private int questionOneScore;
    private int questionTwoScore;
    private int questionThreeScore;
    private int questionFourScore;
    private int questionFiveScore;
    private int totalScore;

    public ScoreSet(String category, int questionOneScore, int questionTwoScore, int questionThreeScore, int questionFourScore, int questionFiveScore) {
        this.category = category;
        this.questionOneScore = questionOneScore;
        this.questionTwoScore = questionTwoScore;
        this.questionThreeScore = questionThreeScore;
        this.questionFourScore = questionFourScore;
        this.questionFiveScore = questionFiveScore;
        this.totalScore = 
                questionOneScore + questionTwoScore + questionThreeScore + 
                questionFourScore + questionFiveScore;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuestionOneScore() {
        return questionOneScore;
    }

    public void setQuestionOneScore(int questionOneScore) {
        this.questionOneScore = questionOneScore;
    }

    public int getQuestionTwoScore() {
        return questionTwoScore;
    }

    public void setQuestionTwoScore(int questionTwoScore) {
        this.questionTwoScore = questionTwoScore;
    }

    public int getQuestionThreeScore() {
        return questionThreeScore;
    }

    public void setQuestionThreeScore(int questionThreeScore) {
        this.questionThreeScore = questionThreeScore;
    }

    public int getQuestionFourScore() {
        return questionFourScore;
    }

    public void setQuestionFourScore(int questionFourScore) {
        this.questionFourScore = questionFourScore;
    }

    public int getQuestionFiveScore() {
        return questionFiveScore;
    }

    public void setQuestionFiveScore(int questionFiveScore) {
        this.questionFiveScore = questionFiveScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
}

