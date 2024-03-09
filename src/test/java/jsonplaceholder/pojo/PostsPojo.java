package jsonplaceholder.pojo;

import lombok.*;

@Data
@Builder
public class PostsPojo {

    int userId;
    int id;
    String title;
    String body;
}
