package kosta.bag;

/**
 *클라이언트에 응답전에
 *이동할 url주소와 이동방식을 관리하는 클래스
 */
public class ModelAndView {
	private String path; //최종 뷰 페이지 이름
	//isRedirect:이동방식(true이면 redirect, false이면 foward ...일반적으로foward가많으므로 false가 기본값)
	private boolean isRedirect;
	
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	} 
	
}
