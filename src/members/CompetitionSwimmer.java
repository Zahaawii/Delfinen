package members;

public class CompetitionSwimmer extends Members{

    private double time;
    private String discipline;
    //private Coach coach;


    public CompetitionSwimmer(int id, String name, String lastname, int age, boolean isActive, boolean isCompetition, boolean quotaPayed, String discipline, double time) {
        super(id, name, lastname, age, isActive, quotaPayed);
        this.discipline = discipline;
        this.time = time;

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



}

