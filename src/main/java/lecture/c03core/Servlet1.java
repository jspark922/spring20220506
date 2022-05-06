package lecture.c03core;

public class Servlet1 {
	private Dao1 dao; // dependency
	
	public void doGet() {
		// request 파라미터 수집 / 가공
		// bussiness 로직 처리
		dao.select();
		// 결과 세팅
		// forward / redirect
	}
}
