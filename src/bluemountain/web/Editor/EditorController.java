package bluemountain.web.Editor;

import bluemountain.protocol.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 54472 on 2017/4/9.
 */
@Controller
public class EditorController {
    private ArticleRepository articleRepository;

    @Autowired
    public EditorController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @RequestMapping(value = {"/editor/editor"}, method = RequestMethod.GET)
    public String editor(Model model){
        model.addAttribute("articles", articleRepository.all());

        return "editor/editor1";
    }

}
