/* 4.애플리케이션에서 하나의데이터로 다루어져야할 정보들을 저장하는 클래스들(DTO=Bean)
 * 4-1 개상품 하나의 정보를 저장하는 클래스
 */

package vo;

import java.sql.Date;

public class Dog {
	private int id;//상품 아이디
	private String kind;//개 품종
	private int price;//개 가격
	private String image;//개 이미지
	private String country;//원산지
	private int height;//평균 개 신장
	private int weight;//평균 개 몸무게
	private String content;//개 설명
	private int readcount;//조회수
	
	//매개변수가 있는 생성자
	public Dog(int id, String kind, int price, String image, String country, int height, int weight, String content,
			int readcount) {
		super();
		this.id = id;
		this.kind = kind;
		this.price = price;
		this.image = image;
		this.country = country;
		this.height = height;
		this.weight = weight;
		this.content = content;
		this.readcount = readcount;
	}
	
	//매개변수가 없는 생성자
	public Dog() {}
	
	//게터와세터
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
}