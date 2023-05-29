package com.example.myapplication.mappers;

import com.example.myapplication.dto.UserDTO;
import com.example.myapplication.vo.UserVO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-29T19:28:30+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO userVOtoDTO(UserVO vo) {
        if ( vo == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        return userDTO;
    }
}
