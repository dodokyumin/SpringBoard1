package kr.ac.kopo.ctc.spring.board.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;

@Controller
public class HelloController {
	
	@RequestMapping(value = "/hello")
	public String hellSpringBoot(Model model) {
		model.addAttribute("name", "홍길동");
		return "hello";
	}
}


