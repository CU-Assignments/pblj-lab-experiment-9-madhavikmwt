import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Course class
class Course {
    private String courseName;
    private int duration; // duration in weeks

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getDuration() {
        return duration;
    }
}

// Student class
class Student {
    private String name;
    private Course course;

    public Student(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Student Name: " + name + ", Course: " + course.getCourseName() + ", Duration: " + course.getDuration() + " weeks";
    }
}

// Configuration class
@Configuration
class AppConfig {

    @Bean
    public Course course() {
        return new Course("Java Programming", 12);
    }

    @Bean
    public Student student() {
        return new Student("John Doe", course());
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Load the Spring context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve the Student bean
        Student student = context.getBean(Student.class);

        // Print student details
        System.out.println(student);
    }
}
