package First;

import javax.persistence.*;

@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    @Enumerated
    private Role role;

    public Long getId() {
        return id;
    }

    public Member setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Member setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Member setAge(int age) {
        this.age = age;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public Member setRole(Role role) {
        this.role = role;
        return this;
    }
}
