//특정 개 상품의 상세 정보보기 요청을 처리하는 Action클래스
package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.DogViewService;
import vo.ActionForward;

public class DogViewAction implements Action {

	@Override
	public ActionForward exeute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		new DogViewService();
		
		return null;
	}

}
