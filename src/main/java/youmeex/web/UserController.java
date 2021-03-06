package youmeex.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import youmeex.domain.User;
import youmeex.domain.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
//	ArrayList<User> users = new ArrayList<>();
	
	@Autowired
	UserRepository userRepository;

	// 회원 가입 기능 구현
	@PostMapping("")
	public ModelAndView creat(User user) {
		userRepository.save(user);
		return new ModelAndView("redirect:/user");
	}
	
	//회원 정보 수정 기능 구현 
	@GetMapping("/{id}/updateForm")
	public String updateForm(@PathVariable Long id, Model model) {
//		User user = userRepository.findOne(id);
//		model.addAttribute("users", user);
		model.addAttribute("users", userRepository.findOne(id));
		return "/user/updateForm";
	}
	
	@PostMapping("/{id}")
	public String update(@PathVariable Long id, User updateUser) {
		User user = userRepository.findOne(id);
		user.update(updateUser);
		userRepository.save(user);
		return "redirect:/user";
	}

	// 회원 목록 기능 구현
	@GetMapping("")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("user/list");
		mav.addObject("users", userRepository.findAll());
		return mav;
	}

	// 이거는 프로필페이지에서 해당 유저 가져오는 코드 @index번의 유저를 불러
	@GetMapping("/{id}")
	public ModelAndView show(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("user/profile");
		mav.addObject("user", userRepository.findOne(id));
		return mav;
	}

	@GetMapping("/form")
	public String userForm() {
		return "user/form";
	}
	
	
	@GetMapping("/profile")
	public String userProfile() {
		return "user/profile";
	}
	
	@GetMapping("/login")
	public String userLogin() {
		return "user/login";
	}
	

//	@GetMapping("{userId}/form")
//	public ModelAndView updateForm(@PathVariable String userId) {
//		User user = this.get(userId);
//				
//		ModelAndView mav = new ModelAndView("user/updateForm");
//		mav.addObject("name", user.getName());
//		mav.addObject("userId", user.getUserId());
//		mav.addObject("email", user.getEmail());
//
//		return mav;
//	}

	// //이거는 프로필페이지에서 해당 유저 가져오는 코드 @index번의 유저를 불러
	// @GetMapping("/users/{userId}/form")
	// public ModelAndView show(@PathVariable String userId) {
	// User user = users.get(index);
	//
	// ModelAndView mav = new ModelAndView("user/profile");
	// mav.addObject("name", user.getName());
	// mav.addObject("email", user.getEmail());
	//
	// return mav;
	// }

	// public ModelAndView creat(String userId, String password, String name, String
	// email) {
	// System.out.println("User id : " + userId);
	// System.out.println("Password : " + password);
	// System.out.println("Name : " + name);
	// System.out.println("E-mail : " + email);
	//
	// User user = new User();
	// user.setUserId(userId);
	// user.setPassword(password);
	// user.setName(name);
	// user.setEmail(email);
	//
	// users.add(user);
	// System.out.println("size : " + users.size());
	//
	// ModelAndView mav = new ModelAndView("user/list");
	// mav.addObject("users", users);
	// return mav;
	//
	// }

}
