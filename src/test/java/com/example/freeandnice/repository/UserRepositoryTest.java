package com.example.freeandnice.repository;import com.example.freeandnice.entities.Item;
import com.example.freeandnice.entities.Message;
import com.example.freeandnice.entities.User;
import com.example.freeandnice.service.impl.ItemService;
import com.example.freeandnice.service.impl.MessageService;
import com.example.freeandnice.utils.DataUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserRepositoryTest {

    @Mock
    UserRepository userRepository;

    @Test
    public void userTest(){
        User user = DataUtils.getUser();
        userRepository.save(user);
        assertThat(userRepository.findByEmail(user.getEmail())).isNotNull();
    }

}