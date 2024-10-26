package unit_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.food.delivery.models.dtos.RequestUserDTO;
import com.itschool.food.delivery.models.dtos.ResponseUserDTO;
import com.itschool.food.delivery.models.entities.User;
import com.itschool.food.delivery.repositories.UserRepository;
import com.itschool.food.delivery.services.UserServiceImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @AfterAll
    public static void test() {
    }

    @Test
    void testCreateUser() {
        //given
        RequestUserDTO requestUserDTO = new RequestUserDTO();
        requestUserDTO.setFirstName("test firstName");
        requestUserDTO.setLastName("test lastName");
        requestUserDTO.setAddress("test address");
        requestUserDTO.setPhoneNumber("5378919265");
        requestUserDTO.setEmail("test@example.com");

        ResponseUserDTO responseUserDTO = new ResponseUserDTO();
        responseUserDTO.setFirstName("test firstName");
        responseUserDTO.setLastName("test lastName");
        responseUserDTO.setAddress("test address");
        responseUserDTO.setPhoneNumber("5378919265");
        responseUserDTO.setEmail("test@example.com");

        User userEntity = new User();
        userEntity.setFirstName("test firstName");
        userEntity.setLastName("test lastName");
        userEntity.setAddress("test address");
        userEntity.setPhoneNumber("5378919265");
        userEntity.setEmail("test@example.com");

        User savedUserEntity = new User();
        savedUserEntity.setFirstName("test firstName");
        savedUserEntity.setLastName("test lastName");
        savedUserEntity.setAddress("test address");
        savedUserEntity.setPhoneNumber("5378919265");
        savedUserEntity.setEmail("test@example.com");

        when(objectMapper.convertValue(requestUserDTO, User.class)).thenReturn(userEntity);
        when(userRepository.save(userEntity)).thenReturn(userEntity);
        when(objectMapper.convertValue(savedUserEntity, ResponseUserDTO.class)).thenReturn(responseUserDTO);

        //when
        ResponseUserDTO savedUserDTO = userService.createUser(requestUserDTO);

        //then
        verify(userRepository, times(1)).save(userEntity);
        assertEquals(requestUserDTO.getFirstName(), savedUserDTO.getFirstName());
        assertEquals(requestUserDTO.getLastName(), savedUserDTO.getLastName());
        assertEquals(requestUserDTO.getAddress(), savedUserDTO.getAddress());
        assertEquals(requestUserDTO.getPhoneNumber(), savedUserDTO.getPhoneNumber());
        assertEquals(requestUserDTO.getEmail(), savedUserDTO.getEmail());
    }
}