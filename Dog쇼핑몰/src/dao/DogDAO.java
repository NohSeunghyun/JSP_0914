//DB로 SQL구문을 전송하는 클래스
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import static db.Jdbcutil.*;//static:모든 메서드들 미리 메모리에 올림

import vo.Dog;

public class DogDAO {
	//멤버변수(전역변수) : 전체 메서드에서 사용 가능
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	String sql = "";
	/* 싱글톤 패턴 : DogDAO객체 단 1개만 생성
	 * 이유? 외부 클래스에서 "처음 생성된 DogDAO객체를 공유해서 사용하도록 하기 위해"
	 */
	
	//싱글톤-1.1
	private DogDAO() {}
	
	//싱클톤-1.2
	private static DogDAO dogDAO;
	//static이유? 객체를 생성하기 전에 이미 메모리에 올라간 getInstance()메서드를 통해서만 DogDAO객체를 만들도록 하기 위해
	public static DogDAO getInstance() {
		if(dogDAO == null) {//객체가 없으면
			dogDAO = new DogDAO();//객체 생성
		}
		return dogDAO;//기존 객체의 주소 리턴
	}
	
	/****************************************************************************************/
	
	public void setConnection(Connection con) {//Connection객체를 받아 DB 연결
		this.con=con;
	}
	
	//1. 모든 개 상품 정보를 조회하여 ArrayList<Dog>객체 반환
	public ArrayList<Dog> selectDogList() {
		ArrayList<Dog> dogList = null;
		try {
			pstmt = con.prepareStatement("select * from dog");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dogList = new ArrayList<Dog>();
				
				/* ★주의 do~while이아닌 while문으로 할 경우 if문에서 rs.next()를 하여 첫번째 레코드로 왔기때문에
				 * while문의 rs.next()를하면
				 * 첫번째 레코드는 뛰어넘기때문에 do~while로 하여 
				 * 첫레코드 조회 후 rs.next()로 다음으로 넘어가야한다.
				 */
				do {
					//방법1
					//Dog dog = new Dog(rs.getInt("id"), 
					//방법2
					dogList.add(new Dog(rs.getInt("id"), 
										rs.getString("kind"), 
										rs.getInt("price"),
										rs.getString("image"),
										rs.getString("country"),
										rs.getInt("height"),
										rs.getInt("weight"),
										rs.getString("content"),
										rs.getInt("readcount")));
					//방법1
					//dogList.add(dog);
				}while(rs.next());
			}//if문 종료
		} catch (SQLException e) {
			System.out.println("selectDogList 에러 : " + e);//e:예외종류+예외메세지
		} finally {
			close(rs);
			close(pstmt);
		}
		return dogList;
	}
	
	//2. id로 조회수 1증가
	public int updateReadCount(int id) {
		int updateCount = 0;
		
		//sql = "update dog set readcount=readcount+1 where id=?";//방법1
		sql = "update dog set readcount=readcount+1 where id="+id;//방법2
		try {
			pstmt = con.prepareStatement(sql);
			//pstmt.setInt(1, id);//방법1
			updateCount = pstmt.executeUpdate();//업데이트가 성공하면 1을 리턴
		}  catch (SQLException e) {
			System.out.println("updateReadCount 에러 : " + e);//e:예외종류+예외메세지
		} finally {
			close(rs);
			close(pstmt);
		}
		return updateCount;
	}
	
	//3. id로 개 정보를 조회하여 Dog객체를 반환
	public Dog selectDog(int id) {
		
		return null;
	}
}
