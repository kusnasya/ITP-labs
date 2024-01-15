public class TeachingAssistant extends Student{
    private String profession;
    public TeachingAssistant(int age, String gender, String fullName, String education, String profession){
        super(age, gender, fullName, education);
        this.profession = profession;
    }
    public TeachingAssistant(String gender, String fullName, String education, String profession){
        super(gender, fullName, education);
        this.profession = profession;
    }
    public TeachingAssistant(){
        this(20, "male", "Bob Bob", "university", "teacher");
    }

    @Override
    public void aging(){
        System.out.println("Oh no, I'm almost old!");
    }
    @Override
    public void say() {
        System.out.println("Hi, I'm a teaching assistant and I help teach students at university");
    }

    public String getProfession(){
        return profession;
    }
    public void setProfession(String profession){
        this.profession = profession;
    }
}
