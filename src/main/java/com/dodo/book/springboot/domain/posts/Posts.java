package com.dodo.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
1) 이 Posts 클래스에는 Setter  메소드가 없는데 getter/setter를 무작정 생성할 경우, 해당 클래스의 인스턴스 값들이 언제 어디서 변해야하는지 코드상으로 명확하게
구분할 수가 없기때문에 차후 기능 변경시 복잡해진다고 한다.
2) setter가 없는 이 상황에서 어떻게 값을 채워 db에 삽입할까?
-> 생성자를 통해 최종값을 채운 후 db에 삽입하는것이며, 변경이 필요한 경우 해당이벤트에 맞는 public 메소드를 호출하여 변경하는것을 전제로한다.
여기선 생성자 대신 @Builder 를 통해 제공되는 빌더 클새를 사용. 생성자나 빌더나 생성시점에 값을 채워주는 역할을 같다. 빌더가 어느필드에 어떤 값을 채워야할지
명확하게 인지할수 있게 보임
 */

@Getter
@NoArgsConstructor // 기본 생성자 자동추가, public Posts() {}와 같은 효과
@Entity //테이블과 링크될 클래스임을 나타냄, 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭한다.
public class Posts {

    @Id // 해당 테이블의 pk필드를 나타냅니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스를 생성, 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함.
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author =author;
    }

}
