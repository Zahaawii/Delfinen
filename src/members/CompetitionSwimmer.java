package members;

import java.util.ArrayList;

public class CompetitionSwimmer extends Members{

    private double time;
    private String discipline;
    private String coach;
    private ArrayList<String> trainingResults;
    private ArrayList<String> competitions;

    public CompetitionSwimmer(int id, String name, String lastname, int age, boolean isActive, boolean isCompetition, boolean quotaPayed, String discipline, double time) {
        super(id, name, lastname, age, isActive, quotaPayed);
        this.discipline = discipline;
        this.time = time;
    }

    public void addTrainingResult(String result){
        trainingResults.add(result);
    }

    public void removeTrainingResult(int index){
        if (trainingResults.isEmpty()){
            System.out.println("Listen er tom");
        } else {
            trainingResults.remove(index);
        }
    }

    public void addCompetition(String competition){
        competitions.add(competition);
    }

    public void removeCompetition(int index){
        if (competitions.isEmpty()){
            System.out.println("Listen er tom");
        } else {
            competitions.remove(index);
        }
    }

    public ArrayList<String> getCompetitions() {
        return competitions;
    }

    public ArrayList<String> getTrainingResults() {
        return trainingResults;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    @Override
    public String toString() {
        return super.toString() + " Discipline: " + discipline;
    }
}

