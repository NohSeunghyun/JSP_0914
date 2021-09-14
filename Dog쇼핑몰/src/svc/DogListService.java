//개 상품 목록보기 요청을 처리하는 비즈니스로직을 구현하는 Service클래스
package svc;

import static db.Jdbcutil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DogDAO;
import vo.Dog;

public class DogListService {
	public ArrayList<Dog> getDogList() {
		//1.커넥션 풀에서 Connection객체를 얻어와
		Connection con = getConnection();
		//2.싱글톤 패턴 : DogDAO객체 생성
		DogDAO dogDAO = DogDAO.getInstance();
		//3.DB작업에 사용될 Connection객체를 DogDAO의 멤버변수로 삽입하여 DB 연결
		dogDAO.setConnection(con);
		
		/*DogDAO의 해당 메서드를 호출하여 처리*/
		ArrayList<Dog> dogList = dogDAO.selectDogList();
		
		//4.해제
		close(con);//Connection객체 해제
		
		return dogList;
	}
}