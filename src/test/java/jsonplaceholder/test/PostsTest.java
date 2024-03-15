package jsonplaceholder.test;

import com.github.javafaker.Faker;
import framework.PropertyReader;
import jsonplaceholder.adapters.PostsAdapter;
import jsonplaceholder.adapters.UserAdapter;
import jsonplaceholder.pojo.PostsPojo;
import org.testng.annotations.Test;

public class PostsTest {
    PropertyReader propertyReader =new PropertyReader();

    @Test
    public void getAllPosts(){
        PostsAdapter postsAdapter = new PostsAdapter();
        postsAdapter.getPosts(propertyReader.getProperty("END_URI_POSTS"),propertyReader.getIntProperty("status200") );

    }
    @Test
    public void getPost(){
        PostsAdapter postsAdapter = new PostsAdapter();
        postsAdapter.getPost(99,propertyReader.getProperty("END_URI_POSTS"),propertyReader.getIntProperty("status200") );
        postsAdapter.getPost(150,propertyReader.getProperty("END_URI_POSTS"),propertyReader.getIntProperty("status200") );

    }
    @Test
    public void getUsers(){
        UserAdapter postsAdapter = new UserAdapter();
        postsAdapter.getUsers(5,propertyReader.getProperty("END_URI_USERS"),propertyReader.getIntProperty("status200") );

    }


    @Test
    public void postAllPosts(){
        Faker faker = new Faker();
        PostsPojo postsPojo = PostsPojo.builder()
                .userId(1)
                .id(101)
                .title(faker.dog().name())
                .body(faker.lordOfTheRings().character())
                .build();
        PostsAdapter postsAdapter = new PostsAdapter();
        postsAdapter.postPost(postsPojo, propertyReader.getProperty("END_URI_POSTS"),propertyReader.getIntProperty("status201"));
    }
}
