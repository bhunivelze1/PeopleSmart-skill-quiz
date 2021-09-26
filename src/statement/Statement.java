package statement;

public class Statement {
    
    final String statement;
    final StatementCategory statementCategory;
    int score = 0;

    public Statement(String question, StatementCategory questionCategory) {
        this.statement = question;
        this.statementCategory = questionCategory;
    }
    public String getStatement() {
        return statement;
    }

    public String getStatementCategory() {
        switch(this.statementCategory) {
            case UnderstandingPeople: return "Understanding People";
            case ExpressingYourselfClearly: return "Expressing Yourself Clearly";
            case AssertingYourNeeds: return "Asserting Your Needs";
            case ExchangingFeedback: return "Exchanging Feedback";
            case InfluencingOthers: return "Influencing Others";
            case ResolvingConflict: return "Resolving Conflict";
            case BeingATeamPlayer: return "Being a Team Player";
            case ShiftingGears: return "Shifting Gears";
        }
        
        return "";
    }
    
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    
}
