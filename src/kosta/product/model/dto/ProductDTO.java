package kosta.product.model.dto;

public class ProductDTO {

	private int proCode;
	private String proName;
	private String proDesc;
	private String proWriteDate;
	private String proBrand;
	private int proPrice;
	private String fileName;
	
	public ProductDTO() {}

	public ProductDTO(int proCode, String proName, String proDesc, String proWriteDate, String proBrand, int proPrice, String fileName) {
		this.proCode = proCode;
		this.proName = proName;
		this.proDesc = proDesc;
		this.proWriteDate = proWriteDate;
		this.proBrand = proBrand;
		this.proPrice = proPrice;
		this.fileName = fileName;
	}
	
	
	//insert에 사용할 생성자
	public ProductDTO(String proName, String proDesc, String proBrand, int proPrice, String fileName) {
		this.proName = proName;
		this.proDesc = proDesc;
		this.proBrand = proBrand;
		this.proPrice = proPrice;
		this.fileName = fileName;
	}
	
	//update에 사용할 생성자
	public ProductDTO(int proCode, String proName, String proDesc, String proBrand, int proPrice, String fileName) {
		this.proCode = proCode;
		this.proName = proName;
		this.proDesc = proDesc;
		this.proBrand = proBrand;
		this.proPrice = proPrice;
		this.fileName = fileName;
	}

	public int getProCode() {
		return proCode;
	}

	public void setProCode(int proCode) {
		this.proCode = proCode;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProDesc() {
		return proDesc;
	}

	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
	}

	public String getProWriteDate() {
		return proWriteDate;
	}

	public void setProWriteDate(String proWriteDate) {
		this.proWriteDate = proWriteDate;
	}

	public int getProPrice() {
		return proPrice;
	}

	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}

	public String getProBrand() {
		return proBrand;
	}

	public void setProBrand(String proBrand) {
		this.proBrand = proBrand;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}	
	
	
}
