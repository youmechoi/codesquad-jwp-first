package youmeex.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import youmeex.domain.Question;
import youmeex.domain.QuestionRepository;

@Controller
@RequestMapping("/qna")
public class QuestionController {
//	ArrayList<Question> qnas = new ArrayList<>();
	
	@Autowired 
	QuestionRepository questionRepository;

	// 질문하기 기능 구현
	@PostMapping("")
	public ModelAndView creat(Question question) {
		questionRepository.save(question);
		return new ModelAndView("redirect:/qna");
	}

	// 질문 목록 기능 구현
	@GetMapping("")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("qna/qnalist");
		mav.addObject("qnas", questionRepository.findAll());
		return mav;
	}

	// 질문 상세페이지 보기 
	@GetMapping("/{id}")
	public ModelAndView show(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("qna/show");
		mav.addObject("question", questionRepository.findOne(id));
		return mav;
	}
	
	@GetMapping("/form")
	public String qnaForm() {
		return "qna/form";
	}
	
	@GetMapping("/list")
	public String qnaList() {
		return "qna/list";
	}
	
}
