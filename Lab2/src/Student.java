public class Student extends Human{
    private String education;
    public Student(int age, String gender, String fullName, String education){
        super(age, gender, fullName);
        this.education = education;
    }
    public Student(String gender, String fullName, String education){
        super(gender, fullName);
        this.education = education;
    }

    public Student(){
        this(16,"male","Bob Bob", "");
    }

    @Override
    public void aging() {
        System.out.println("Oh no! I'm aging!");
    }

    @Override
    public void say() {
        System.out.println("Hi, I'm student and I'm studying at university");
    }
    public String getEducation(){
        return education;
    }
    public void setEducation(String education){
        this.education = education;
    }
}
