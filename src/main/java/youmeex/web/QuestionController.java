package youmeex.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import youmeex.domain.Question;

@Controller
public class QuestionController {
	ArrayList<Question> qnas = new ArrayList<>();

	// 질문하기 기능 구현
	@PostMapping("/qna")
	public ModelAndView creat(Question question) {
		qnas.add(question);
		return new ModelAndView("redirect:/qna");
	}

	// 질문 목록 기능 구현
	@GetMapping("/qna")
	public ModelAndView list() {

		ModelAndView mav = new ModelAndView("qna/list");
		mav.addObject("qnas", qnas);
		return mav;
	}

	// 질문 상세페이지 보기 
	@GetMapping("/qnas/{index}")
	public ModelAndView show(@PathVariable int index) {
		Question question = qnas.get(index);

		ModelAndView mav = new ModelAndView("qna/show");
		mav.addObject("writer", question.getWriter());
		mav.addObject("contents", question.getContents());

		return mav;
	}
}
