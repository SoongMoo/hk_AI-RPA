package hkAiRpaProject.service.help;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import hkAiRpaProject.command.FindIdCommand;
import hkAiRpaProject.domain.FindIdPasswordVO;
import hkAiRpaProject.mapper.FindMapper;

@Service
public class FindIdService {
	@Autowired
	FindMapper findMapper;
	public void execute(FindIdCommand findIdCommand , BindingResult result, Model model) {
		FindIdPasswordVO vo = findMapper.findId(findIdCommand.getUserPhone());
		if(vo != null) {
			if(vo.getUserEmail().equals(findIdCommand.getUserEmail())) {
				model.addAttribute("userId", vo.getUserId());
			}else {
				result.rejectValue("userEmail","wrong");
				//result.rejectValue("userEamil", "findIdCommand.userEamil", "입력한 이메일이 틀렸습니다.");
			}
		}else {
			result.rejectValue("userPhone","bad");
		}
	}
}
