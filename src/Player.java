public class Player {

    public String firstName;
    public String lastName;
    public String team;
    public int age;

    public Player(String firstName,String lastName, String team, int age)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.team = team;
        this.age = age;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getTeam()
    {
        return team;
    }

    public void setTeam(String team)
    {
        this.team = team;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name : " + this.firstName + " " + this.lastName + ", Team :" + this.team + ", Age : " + this.age;
    }
}
