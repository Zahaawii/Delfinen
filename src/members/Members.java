package members;

//Blueprint on what our members need to be a member
public class Members {

    private int id;
    private String name;
    private String lastname;
    private int age;
    private boolean isActive;
    private boolean quotaPayed;

    private double quota;

    public Members(int id, String name, String lastname, int age, boolean isActive, boolean quotaPayed) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.isActive = isActive;
        this.quotaPayed = quotaPayed;

        MembersList.memberList.add(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setQuotaPayed(boolean quotaPayed) {
        this.quotaPayed = quotaPayed;
    }

    public boolean getQuotaPayed() {
        return quotaPayed;
    }

    public double getQuota() {
        return quota;
    }

    public void setQuota(double quota) {
        this.quota = quota;
    }

    @Override
    public String toString() {
        return "ID: " + id + " Name: " + name + " Lastname: " + lastname + " Age: " + age +
                "\nActive status: " + isActive  + "\nQuota payed: " + quotaPayed;
    }


}
