package statement;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import score.ScoreSet;

public class StatementList {
   
    static int index = 0;
    static private ArrayList<Statement> statementList = new ArrayList<>(Arrays.asList(
            
            //Understanding People
            new Statement("I listen attentively to grasp what someone is thinking.",
                    StatementCategory.UnderstandingPeople),
            new Statement("I take notice of other people's body language to understand them better.",
                    StatementCategory.UnderstandingPeople),
            new Statement("To avoid misundertanding, I ask questions that clarify what the speaker is saying.", 
                    StatementCategory.UnderstandingPeople),
            new Statement("I am able to sense what another person is feeling.",
                    StatementCategory.UnderstandingPeople),
            new Statement("I can decipher the underlying reasons why people I know act the way they do.",
                    StatementCategory.UnderstandingPeople),
            
            //Expressing Yourself Clearly
            new Statement("I give just enough detail so that I'm understood.",
                    StatementCategory.ExpressingYourselfClearly),
            new Statement("People enjoy listening to me.",
                    StatementCategory.ExpressingYourselfClearly),
            new Statement("I can take something complicated and explain it clearly.",
                    StatementCategory.ExpressingYourselfClearly),
            new Statement("I say what I mean and what I feel.",
                    StatementCategory.ExpressingYourselfClearly),
            new Statement("When I'm not clear, I let the other person ask question"
                    + " rather than go on and on explaining myself.",
                    StatementCategory.ExpressingYourselfClearly),
            
            //Asserting Your Needs
            new Statement("I am decisive about what I will do or not do for others.",
                    StatementCategory.AssertingYourNeeds),
            new Statement("I speak up when my needs are not being met.",
                    StatementCategory.AssertingYourNeeds),
            new Statement("I keep calm and remain confident when I get opposition.",
                    StatementCategory.AssertingYourNeeds),
            new Statement("I stand my ground.",
                    StatementCategory.AssertingYourNeeds),
            new Statement("I can say no with grace and tact.",
                    StatementCategory.AssertingYourNeeds),
            
            //Exchanging Feedback
            new Statement("I give appreciation and compliments freely.",
                    StatementCategory.ExchangingFeedback),
            new Statement("When I criticize people, I offer suggestions for improvement.",
                    StatementCategory.ExchangingFeedback),
            new Statement("To get different perspectives, I ask for feedback from a wide range of people.",
                    StatementCategory.ExchangingFeedback),
            new Statement("I ask others for feedback to improve myself, not to fish for compliments.",
                    StatementCategory.ExchangingFeedback),
            new Statement("I listen to feedback I receive from others.",
                    StatementCategory.ExchangingFeedback),
            
            //Influencing Others
            new Statement("I establish rapport with people before trying to persuade them to do something.",
                    StatementCategory.InfluencingOthers),
            new Statement("I explore other people's viewpoints before trying to convince them of my own.",
                    StatementCategory.InfluencingOthers),
            new Statement("I give compelling reasons for adopting my viewpoint.",
                    StatementCategory.InfluencingOthers),
            new Statement("People are not defensive when I give advice.",
                    StatementCategory.InfluencingOthers),
            new Statement("I give people time to mull over what I've presented to them.",
                    StatementCategory.InfluencingOthers),
            
            //Resolving Conflict
            new Statement("I get the tensions between the other person and myself out on the table.",
                    StatementCategory.ResolvingConflict),
            new Statement("Right from the start, I seek agreement over victory.",
                    StatementCategory.ResolvingConflict),
            new Statement("I learn all I can about the other person's needs and interests when negotiating.",
                    StatementCategory.ResolvingConflict),
            new Statement("I work to solve problems, not blame others, when we hit a stone wall.",
                    StatementCategory.ResolvingConflict),
            new Statement("When I reach an agreement with someone, I make sure we both stick to it.",
                    StatementCategory.ResolvingConflict),
            
            //Being a Team Player
            new Statement("I request help from others and give them assistance in return.",
                    StatementCategory.BeingATeamPlayer),
            new Statement("I pitch in when the group needs something done.",
                    StatementCategory.BeingATeamPlayer),
            new Statement("I focus on other people's welfare as much as my own.",
                    StatementCategory.BeingATeamPlayer),
            new Statement("I keep others informed about what I'm doing if it affects them.",
                    StatementCategory.BeingATeamPlayer),
            new Statement("I help to facilitate and coordinate the efforts of others.",
                    StatementCategory.BeingATeamPlayer),
            
            //Shifting Gears
            new Statement("When a relationship is not going well, I take the initiative to do something about it.",
                    StatementCategory.ShiftingGears),
            new Statement("I can see the patterns I fall into with other people.",
                    StatementCategory.ShiftingGears),
            new Statement("Even if I'm not at fault, "
                    + "I am open to making significant changes in my behavior when necessary.",
                    StatementCategory.ShiftingGears),
            new Statement("I am willing to take risks when they are called for.",
                    StatementCategory.ShiftingGears),
            new Statement("I am resilient. If things don't work out, I bounce back.",
                    StatementCategory.ShiftingGears)));
    
    static public ArrayList<Statement> getAllStatement() {
        return statementList;
    }
    
    static public boolean hasNextStatement() {
        if (index < 40) {
            return true;
        } else {
            return false;
        }
    }
    
    static public Statement getNextStatement() {
        Statement statement = statementList.get(index);
        index++;
        return statement;
    }
    
    static public int getIndex() {
        return index;
    }
    
    static public ObservableList<ScoreSet> getScoreSet() {
        ObservableList<ScoreSet> scores = FXCollections.observableArrayList();
        scores.add(new ScoreSet(
                "Understanding People",
                statementList.get(0).getScore(),
                statementList.get(1).getScore(),
                statementList.get(2).getScore(),
                statementList.get(3).getScore(),
                statementList.get(4).getScore()));
        scores.add(new ScoreSet(
                "Expressing Yourself Clearly",
                statementList.get(5).getScore(),
                statementList.get(6).getScore(),
                statementList.get(7).getScore(),
                statementList.get(8).getScore(),
                statementList.get(9).getScore()));
        scores.add(new ScoreSet(
                "Asserting Your Needs",
                statementList.get(10).getScore(),
                statementList.get(11).getScore(),
                statementList.get(12).getScore(),
                statementList.get(13).getScore(),
                statementList.get(14).getScore()));
        scores.add(new ScoreSet(
                "Exchanging Feedback",
                statementList.get(15).getScore(),
                statementList.get(16).getScore(),
                statementList.get(17).getScore(),
                statementList.get(18).getScore(),
                statementList.get(19).getScore()));
        scores.add(new ScoreSet(
                "Influencing Others",
                statementList.get(20).getScore(),
                statementList.get(21).getScore(),
                statementList.get(22).getScore(),
                statementList.get(23).getScore(),
                statementList.get(24).getScore()));
        scores.add(new ScoreSet(
                "Resolving Conflict",
                statementList.get(25).getScore(),
                statementList.get(26).getScore(),
                statementList.get(27).getScore(),
                statementList.get(28).getScore(),
                statementList.get(29).getScore()));
        scores.add(new ScoreSet(
                "Being a Team Player",
                statementList.get(30).getScore(),
                statementList.get(31).getScore(),
                statementList.get(32).getScore(),
                statementList.get(33).getScore(),
                statementList.get(34).getScore()));
        scores.add(new ScoreSet(
                "Shifting Gears",
                statementList.get(35).getScore(),
                statementList.get(36).getScore(),
                statementList.get(37).getScore(),
                statementList.get(38).getScore(),
                statementList.get(39).getScore()));
        
        return scores;
    }
    
    static public int getTotalScore() {
        int totalScore = 0;
        for (Statement statement : statementList)  {
            totalScore += statement.getScore();
        }
        return totalScore;
    }
}
