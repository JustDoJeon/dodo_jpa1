package com.dodo.book.springboot.service;

import com.dodo.book.springboot.domain.posts.Posts;
import com.dodo.book.springboot.domain.posts.PostsRepository;
import com.dodo.book.springboot.web.dto.PostsListsResponseDto;
import com.dodo.book.springboot.web.dto.PostsResponseDto;
import com.dodo.book.springboot.web.dto.PostsSaveRequestDto;
import com.dodo.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        posts.update(requestDto.getTitle(),requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id= " + id));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true) //트랜잭션 범위는 유지하되, 조회 기능만 남겨두어 조회속도가 개선되기때문에 등록,수정, 삭제 기능이 없는 서비스 메서드에 사용추천
    public List<PostsListsResponseDto> findAllDesc() {
        // .map(posts -> new PostsListsResponseDto(posts)) 과 같은것으로 postsRepository 결과로 넘어온 Posts의 Stream을 map을 통해 PostsListsResponseDto 변환->List로 반환하는 메소드 입니다.
        return postsRepository.findAllDesc().stream()
                .map(PostsListsResponseDto::new)
                .collect(Collectors.toList());

    }
}
