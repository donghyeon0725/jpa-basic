package First;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Club {
    @Id
    private Long id;

    private String name;

    public String getName() {
        return name;
    }

    public Club() {}

    public Club(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
