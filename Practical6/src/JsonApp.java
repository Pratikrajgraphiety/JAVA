import org.json.JSONObject;

public class JsonApp {

    // Class to represent a Person
    static class Person {
        String name;
        int age;
        String email;

        Person(String name, int age, String email) {
            this.name = name;
            this.age = age;
            this.email = email;
        }
    }

    public static void main(String[] args) {

        // Encode (Java Object -> JSON)
        Person person = new Person(
                "Pratik",
                19,
                "rajbharpratikcs252637@gmail.com"
        );

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name", person.name);
        jsonObject.put("age", person.age);
        jsonObject.put("email", person.email);

        System.out.println("Encoded JSON:");
        System.out.println(jsonObject.toString(2));

        // Decode (JSON -> Java Object)
        String jsonString = jsonObject.toString();

        JSONObject parsed = new JSONObject(jsonString);

        String name = parsed.getString("name");
        int age = parsed.getInt("age");
        String email = parsed.getString("email");

        Person decodedPerson = new Person(
                name,
                age,
                email
        );

        System.out.println("\nDecoded Person Object:");
        System.out.println("Name: " + decodedPerson.name);
        System.out.println("Age: " + decodedPerson.age);
        System.out.println("Email: " + decodedPerson.email);
    }
}