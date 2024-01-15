public class Professor extends TeachingAssistant {
    private int teachingExperience;
    public Professor(int age, String gender, String fullName, String education, String profession, int teachingExperience){
        super(age, gender, fullName, education, profession);
        this.teachingExperience = teachingExperience;
    }
    public Professor(String gender, String fullName, String education,
                     String profession, int teachingExperience){
        super(gender, fullName, education, profession);
        this.teachingExperience = teachingExperience;
    }
    public int getTeachingExperience(){
        return teachingExperience;
    }
    public void setTeachingExperience(int teachingExperience){
        this.teachingExperience = teachingExperience;
    }

    @Override
    public void aging(){
        System.out.println("Oh no, where are my college years?");
    }
    @Override
    public void say() {
        System.out.println("Hello, I'm a professor and I teach students at university");
    }
}
