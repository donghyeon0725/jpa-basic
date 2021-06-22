package Fifth.실전예제;

import org.omg.CORBA.PRIVATE_MEMBER;

import javax.persistence.*;
import java.util.List;

@Entity
public class QCategory {
    @Id
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "QCATEGORY_ID")
    private QCategory parentCategory;

    @OneToMany(mappedBy = "parentCategory")
    private List<QCategory> childCategories;

    @OneToMany(mappedBy = "category")
    private List<QCategoryItem> qCategoryItems;
}
