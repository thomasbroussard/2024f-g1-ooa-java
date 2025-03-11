package fr.epita.biostats.tests;

public class SandboxTest {

    public static void main(String[] args) {
        

        String line = "\"Alex\",       \"M\",   41,       74,      170";
        String[] parts = line.split(",");
        String cleanName = parts[0].replace("\"", "").strip();
        String cleanGender = parts[1].replace("\"", "").strip();
        System.out.println(cleanName);
        Integer cleanAge = Integer.parseInt(parts[2].strip());
        Integer cleanHeight = Integer.parseInt(parts[3].strip());
        Integer cleanWeight = Integer.parseInt(parts[4].strip());
        System.out.println(cleanAge);
    }
}
