public abstract class Human {
    private int age;
    private String gender;
    private String fullName;
    private static int instanceCounter = 0;
    public abstract void aging();
    public abstract void say();

    //Знаем возраст человека
    public Human(int age, String gender, String fullName){
        this.age = age;
        this.gender = gender;
        this.fullName = fullName;
        instanceCounter++;
    }
    //Не знаем возраст человека - перегрузка
    public Human(String gender, String fullName){
        this.gender = gender;
        this.fullName = fullName;
        instanceCounter++;
    }
    public static int getNumOfInstances() {
        return instanceCounter;
    }

    public int getAge(){
        return age;
    }
    public String getGender(){
        return gender;
    }
    public String getFullName(){
        return fullName;
    }
    public void setAge(int age){
        if (age >= 0){
            this.age = age;
        } else {
            System.out.println("A person's age cannot be negative.");
        }
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
}
