
import lombok.Data;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Banner{
    private int id;
    private String name;
    private String description;
    private String items;
}