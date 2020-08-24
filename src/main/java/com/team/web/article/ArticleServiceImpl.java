package com.team.web.article;
import com.team.web.common.JpaService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
interface ArticleService extends JpaService<Article> {
    Optional<Article> createUsed(Article article);


    Article update(Article modifyArticle);

    Optional<Article> findUserByArticleId(Long articleId);

    Optional<Article> findOne(Long articleId);

    void delete(Article deleteOne);
}

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Optional<Article> createUsed(Article article) {
        Article createUsedArticle = new Article();
        createUsedArticle.setTitle(article.getTitle());
        createUsedArticle.setWriter(article.getWriter());
        createUsedArticle.setAddress(article.getAddress());
        createUsedArticle.setContents(article.getContents());
        System.out.println(createUsedArticle);
        Article usedData= articleRepository.save(createUsedArticle);
        return Optional.of(usedData);
    }

    @Override
    public Article update(Article modifyArticle) {
        return articleRepository.save(modifyArticle);
    }

    @Override
    public Optional<Article> findUserByArticleId(Long articleId) {
        return articleRepository.findById(articleId);
    }

    @Override
    public Optional<Article> findOne(Long articleId) {
        return articleRepository.findById(articleId);
    }

    @Override
    public Iterable<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Optional<Article> findById(String articleId) {
        return articleRepository.findById(Long.valueOf(articleId));
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void delete(Article deleteOne) {
        articleRepository.delete(deleteOne);

    }

    @Override
    public boolean exists(String id) {
        return false;
    }
}