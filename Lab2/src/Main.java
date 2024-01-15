public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(21,"male", "Ivanov Ivan", "school");
        Student student2 = new Student("female", "Ivanova Maria", "school");

        System.out.println("Gender, age - " + student1.getGender() + ", " + student1.getAge() +
                "; name - " + student1.getFullName() + ", his/her education - " + student1.getEducation());
        System.out.println("Gender, age - " + student1.getGender() + ", " + student1.getAge() +
                "; name - " + student2.getFullName() + ", his/her education - " + student2.getEducation());

        TeachingAssistant teachingAssistant1 = new TeachingAssistant(24, "female",
                "Petrova Anna", "university", "dancer");

        System.out.println("Age - " + teachingAssistant1.getAge() + ", gender - " + teachingAssistant1.getGender()
                + ", name - " + teachingAssistant1.getFullName() + ", his/her education - "
                + teachingAssistant1.getEducation() + ", profession - " + teachingAssistant1.getProfession());

        teachingAssistant1.setAge(30);
        System.out.println("Age - " + teachingAssistant1.getAge() + ", gender - " + teachingAssistant1.getGender()
                + ", name - " + teachingAssistant1.getFullName() + ", his/her education - "
                + teachingAssistant1.getEducation() + ", profession - " + teachingAssistant1.getProfession());

        Professor professor1 = new Professor(35, "female", "Bob Bob", "university", "dancer", 5);
        System.out.println("Age - " + professor1.getAge() + ", gender - " + professor1.getGender()
                + ", name - " + professor1.getFullName() + ", his/her education - "
                + professor1.getEducation() + ", profession - " + teachingAssistant1.getProfession() + ", his/her experience - " + professor1.getTeachingExperience());

        student1.aging();
        teachingAssistant1.aging();
        professor1.aging();
        System.out.println("How much persons at university - " + Human.getNumOfInstances());
    }
}