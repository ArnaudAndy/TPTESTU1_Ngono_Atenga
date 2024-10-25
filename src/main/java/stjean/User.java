package stjean;

import java.util.ArrayList;

public class User {

    private int id;
    private String name;
    private int age;
    private String email;
    private String phone;
    private String city;
    private double balancePersonnel;


    public static ArrayList<User> users = new ArrayList<>();

    public User(int id, String name, int age, String email, String phone, String city, double balancePersonnel) throws EmailInvalidException {
        validateEmail(email);
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.balancePersonnel = balancePersonnel;
    }


    public static void validateEmail(String email) throws EmailInvalidException {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        if (!email.matches(emailRegex)) {
            throw new EmailInvalidException("wrong email format: " + email);
        }
    }


    public static void add(User user) throws EmailInvalidException {
        validateEmail(user.getEmail());
        users.add(user);
    }


    public static void delete(int id) throws DeletionInvalidException {
        boolean removed = users.removeIf(user -> user.getId() == id);
        if (!removed) {
            throw new DeletionInvalidException("No user found with ID: " + id);
        }
    }


    public static void list() {
        for (User user : users) {
            System.out.println(user);
        }
    }


    public static void display(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                System.out.println(user);
                return;
            }
        }
        System.out.println("No user found with ID: " + id);
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    public double getBalancePersonnel() {
        return balancePersonnel;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                ", balancePersonnel=" + balancePersonnel +
                '}';
    }
}
