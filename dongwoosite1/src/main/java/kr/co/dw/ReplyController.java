package kr.co.dw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.dw.domain.Reply;
import kr.co.dw.service.ReplyService;

@RestController
public class ReplyController {
	@Autowired
	private ReplyService replyService;

	// 댓글 저장을 위한 요청
	@RequestMapping(value = "reply/register", method = RequestMethod.GET)
	public Map<String, Object> register(HttpServletRequest request) {
		// 댓글 저장 처리 후 작동 유무 확인 
		boolean result = replyService.register(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		return map;
	}
	//댓글 목록을 가져오는 메소드
	@RequestMapping(value="reply/list", method=RequestMethod.GET)
	public List<Reply> list(HttpServletRequest request){
		
		return replyService.list(request);
	}
	
	// 댓글 삭제를 처리하는 메소드
	@RequestMapping(value = "reply/delete", 
			method = RequestMethod.GET)
	public Map<String, Object> delete(HttpServletRequest request) {
		boolean result = replyService.delete(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		return map;
	}
	// 댓글 수정을 처리하는 메소드
		@RequestMapping(value = "reply/update", method = RequestMethod.GET)
		public Map<String, Object> update(HttpServletRequest request) {
			boolean result = replyService.update(request);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("result", result);
			return map;
		}

}