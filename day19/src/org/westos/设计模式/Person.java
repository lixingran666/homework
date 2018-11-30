package org.westos.设计模式;

public class Person {
    private String sex;
    private String name;
    private Integer weight;
    private Integer height;

    public Person(String sex, String name, Integer weight, Integer height) {
        this.sex = sex;
        this.name = name;
        this.weight = weight;
        this.height = height;
    }

    //建造器
    public static class PersonBuilder{
        private String sex;
        private String name;
        private Integer weight;
        private Integer height;

        public PersonBuilder sex(String sex) {
            this.sex = sex;
            return this;
        }

        public PersonBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder weight(Integer weight) {
            this.weight = weight;
            return this;
        }

        public PersonBuilder height(Integer height) {
            this.height = height;
            return this;
        }

        public Person build(){
            return new Person(this.sex,this.name,this.height,this.weight);
        }
    }

    public String getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "sex='" + sex + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}
