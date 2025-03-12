package fr.epita.biostats.datamodel;

public class BiostatEntry {
    private String name;
    private String gender;
    private Integer age;
    private Integer height;
    private Integer weight;

    public BiostatEntry(String name, String gender, Integer age, Integer height, Integer weight) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "BiostatEntry [" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ']';
    }
}
