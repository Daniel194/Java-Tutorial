package employee;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

public class EmployeeControllerTest {
    private List<Employee> database;
    private EmployeeController rest;
    private MockMvc endpoint;
    private EmployeeRepository repo;

    @Before
    public void setup() {
        database = new ArrayList<>();
        repo = mock(EmployeeRepository.class);
        rest = new EmployeeController(repo);
        endpoint = standaloneSetup(rest).build();
    }

    @Test
    public void createOk() throws Exception {
        doAnswer(i -> {
            final Employee entity = i.getArgumentAt(0, Employee.class);
            database.add(entity);
            return entity;
        }).when(repo).save(any(Employee.class));

        doAnswer(i -> database).when(repo).findAll();

        endpoint
                .perform(post("/employee").contentType(APPLICATION_JSON).content("{\n" +
                        "  \"id\": \"55fb2f1930e07c6c844b02ff\",\n" +
                        "  \"email\": \"dan.greene@3pillarglobal.com\",\n" +
                        "  \"fullName\": \"Daniel Greene\",\n" +
                        "  \"managerEmail\": null\n" +
                        "}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fullName").value("Daniel Greene"));
    }
}
