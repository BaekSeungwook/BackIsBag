package kosta.bag;

/**
 *Ŭ���̾�Ʈ�� ��������
 *�̵��� url�ּҿ� �̵������ �����ϴ� Ŭ����
 */
public class ModelAndView {
	private String path; //���� �� ������ �̸�
	//isRedirect:�̵����(true�̸� redirect, false�̸� foward ...�Ϲ�������foward�������Ƿ� false�� �⺻��)
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
