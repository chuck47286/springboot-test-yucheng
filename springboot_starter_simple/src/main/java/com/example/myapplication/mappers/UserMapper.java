package com.example.myapplication.mappers;

import com.example.myapplication.dto.UserDTO;
import com.example.myapplication.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userVOtoDTO(UserVO vo);
}
