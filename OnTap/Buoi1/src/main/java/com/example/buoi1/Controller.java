package com.example.buoi1;

import com.example.buoi1.comment.Comment;
import com.example.buoi1.comment.CommentDTO;
import com.example.buoi1.comment.CommentRepository;
import com.example.buoi1.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class Controller {

    private final CommentRepository commentRepository;

    private final UserRepository userRepository;

//    @PostMapping("/create-parent")
//    public ResponseEntity<?> createParent(@RequestBody CommentDTO commentDTO) throws Exception {
//        Comment comment = new Comment();
//        comment.setContent(commentDTO.getContent());
//        comment.setParentComment(null);
//        return ResponseEntity.ok(commentRepository.save(comment));
//    }
//
//    @PostMapping("/create-children")
//    public ResponseEntity<?> create(@RequestBody CommentDTO commentDTO) throws Exception {
//        Optional<Comment> parentComment = commentRepository.findById(commentDTO.getParentId());
//        Comment comment = new Comment();
//        comment.setContent(commentDTO.getContent());
//        comment.setParentComment(parentComment.get());
//        return ResponseEntity.ok(commentRepository.save(comment));
//    }

    @GetMapping("/user")
    public ResponseEntity<?> get(@RequestParam String username) throws Exception {
        return ResponseEntity.ok(userRepository.findUserByUsername1(username));
    }

    //mvn clean install
    //java -jar target/fileName.jar
}
