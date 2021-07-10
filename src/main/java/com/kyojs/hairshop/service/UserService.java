package com.kyojs.hairshop.service;

import com.kyojs.hairshop.domain.user.User;
import com.kyojs.hairshop.domain.user.UserRepository;
import com.kyojs.hairshop.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional Long save(UserDto.SaveRequest requestDto){
        return userRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, UserDto.UpdateRequest requestDto){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id = " + id));
        user.update(requestDto.getPasswd(), requestDto.getEmail(), requestDto.getName(), requestDto.getGender(), requestDto.getBirth(), requestDto.getTel(), requestDto.getAddress());
        return id;
    }

    public UserDto.Response findById(Long id) {
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id = " + id));

        return new UserDto.Response(entity);
    }

    @Transactional
    public List<UserDto.ListResponse> findAllDesc() {
        return userRepository.findAllDesc().stream()
                .map(UserDto.ListResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("햐해당 유저가 없습니다. id= " + id));

        userRepository.delete(user);
    }
}
