package com.team.web.article;
import com.team.web.common.Box;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/articles")
@AllArgsConstructor

public class ArticleController {
    private final ArticleService articleService;
    static Logger logger = LoggerFactory.getLogger(ArticleController.class);
    @Autowired Box box;

    @PostMapping("/createUsed")
    public ResponseEntity<Article> createUsed(@RequestBody Article article){
        System.out.println("자바 확인 "+ article);
        Optional<Article> createUsed= articleService.createUsed(article);
        if(createUsed.isPresent()){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/list")
    public Map<?,?> getAll(){
        Iterable<Article> articlesList= articleService.findAll();
        box.put("list",articlesList);
        return box.get();
    }
    @GetMapping("/findUser/{articleId}")
    public Optional<Article> getOneUser(@PathVariable String articleId){
        System.out.println("자바 진입 확인 게시판 number" + articleId);
        return articleService.findById(articleId);
    }
    @PatchMapping("/update/{articleId}")
    public ResponseEntity<Article> update(@PathVariable String articleId, @RequestBody Article article){
        Optional<Article> updateArticle= articleService.findUserByArticleId(Long.valueOf(articleId));
        if(updateArticle.isPresent()){
            Article modifyArticle= updateArticle.get();
            Optional.ofNullable(article.getTitle()).ifPresent(modifyArticle::setTitle);
            Optional.ofNullable(article.getWriter()).ifPresent(modifyArticle::setWriter);
            Optional.ofNullable(article.getAddress()).ifPresent(modifyArticle::setAddress);
            Optional.ofNullable(article.getContents()).ifPresent(modifyArticle::setContents);
            return ResponseEntity.ok(articleService.update(modifyArticle));
        }else {
            System.out.println("업데이트 실패");
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/delete/{articleId}")
    public ResponseEntity<Article> deleteArticle(@PathVariable String articleId){
        Optional<Article> findOne = articleService.findOne(Long.valueOf(articleId));
        if(findOne.isPresent()){
            Article deleteOne= findOne.get();
            articleService.delete(deleteOne);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
