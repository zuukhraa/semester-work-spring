package ru.itis.shagiakhmetova.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.shagiakhmetova.models.Post;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {

    private Long id;

    private LocalDateTime createdAt;

    @NotBlank
    @Size(min = 2, max = 20)
    private String title;

    @NotBlank
    @Size(min = 2, max = 500)
    private String text;

    private Long accountId;

    public static PostDto from(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .createdAt(post.getCreatedAt())
                .title(post.getTitle())
                .text(post.getText())
                .accountId(post.getAccount().getId())
                .build();
    }

    public static List<PostDto> from(List<Post> posts) {
        return posts.stream().map(PostDto::from).collect(Collectors.toList());
    }
}
