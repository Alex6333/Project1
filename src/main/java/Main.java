public class Main {

    public static void main(String[] args) {

        University medUniversity = new University("1","Самарский Государственный Медицинский Университет"
                ,"СамГМУ",1930,StudyProfile.MEDICINE);
        Student medicStudent = new Student("Иван Иванов","1",3,  4.3f);
        System.out.println(medicStudent);
        System.out.println(medUniversity);
    }
}
